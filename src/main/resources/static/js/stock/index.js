document.addEventListener("DOMContentLoaded", () => {
    window.request = async function(page) {
        const response = await fetch(`/api/stock/list?page=${page}`);
        const jsonData = await response.json();

        const tableBody = document.getElementById("stockTableBody");
        tableBody.innerHTML = "";

        // jsonData.pages.content에서 데이터를 가져옴
        const stocks = jsonData.pages.content;

        // 각 창고 정보를 테이블에 추가
        stocks.forEach(stock => {
            const row = document.createElement("tr");

            // 실 수량 입력창과 비고 입력창
            const actualQuantityInput = stock.actualQuantity === null
                ? `<input type="number" class="form-control" id="actualQuantity_${stock.id}" placeholder="수량 입력"  min="0"/>`
                : `<input type="number" class="form-control" value="${stock.actualQuantity}" id="actualQuantity_${stock.id}"  min="0"/>`;

            const remarksInput = `<input type="text" class="form-control" value="${stock.remarks || ''}" id="remarks_${stock.id}" placeholder="비고 입력" />`;

            // 수정 버튼
            const updateButton = document.createElement("button");
            updateButton.className = "btn btn-success";
            updateButton.textContent = "수정";
            updateButton.onclick = async () => {
                const actualQuantity = document.getElementById(`actualQuantity_${stock.id}`).value;
                const remarks = document.getElementById(`remarks_${stock.id}`).value;

                // 서버에 수정 요청 보내기
                const response = await fetch(`/api/stock/${stock.id}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    body: JSON.stringify({
                        actualQuantity: actualQuantity,
                        remarks: remarks
                    }),
                });

                if (response.ok) {
                    alert('수정되었습니다!');
                    window.request(page); // 수정 후 데이터 새로고침
                }
            };

            // 상세보기 버튼 생성
            const detailButton = document.createElement("button");
            detailButton.setAttribute("type", "button");
            detailButton.setAttribute("data-stock-id", `${stock.id}`);
            detailButton.setAttribute("data-bs-toggle", "modal");
            detailButton.setAttribute("data-bs-target", "#exampleModal");
            detailButton.className = "btn btn-info";
            detailButton.textContent = "상세보기";

            const stockLogs = [

            ];

            detailButton.onclick = async () => {


                console.log(detailButton.dataset);
                const stockId = detailButton.dataset.stockId; // data-stock-id 값 가져오기
                console.log(stockId);

                const response = await fetch(`/api/stocklog/list?stock_id=${stockId}`);

                const jsonData = await response.json();

                console.log(jsonData);

                const log = jsonData.pages.content;

                console.log(log);

                log.forEach(data => {
                    stockLogs.push(data);
                })

                showProductDetails(stock.product, stockLogs);
            };

            row.innerHTML = `
            <th scope="row">${stock.id}</th>
            <td>${stock.cellId}</td>
            <td>${stock.quantity}</td>
            <td>${actualQuantityInput}</td>
            <td>${remarksInput}</td>
        `;

            // 수정 버튼을 행에 추가
            const cell = document.createElement("td");
            cell.appendChild(updateButton);
            row.appendChild(cell);

            // 등록 날짜를 위한 셀
            const dateCell = document.createElement("td");
            dateCell.textContent = new Date(stock.createdAt).toLocaleDateString();
            row.appendChild(dateCell);

            // 상세보기 버튼을 행에 추가
            const detailCell = document.createElement("td");
            detailCell.appendChild(detailButton);
            row.appendChild(detailCell);

            tableBody.appendChild(row);
        });

        // 상세보기 버튼 클릭 시 상품 정보를 모달에 표시하는 함수
        function showProductDetails(product, stockLogs) {
            const productDetails = document.getElementById("productDetails");

            // QR 코드 URL 생성
            const qrCodeURL = generateQRCodeURL(product);
            console.log(qrCodeURL);

            // 상품 정보를 HTML로 생성
            productDetails.innerHTML = `
                <p><strong>상품명:</strong> ${product.name}</p>
                <p><strong>코드:</strong> ${product.code}</p>
                <p><strong>제조사:</strong> ${product.manufacturer}</p>
                <p><strong>가격:</strong> ${product.actualPrice.toLocaleString()} 원</p>
                <p><strong>판매가:</strong> ${product.salePrice.toLocaleString()} 원</p>
                <p><strong>크기:</strong> ${product.height}mm x ${product.width}mm x ${product.depth}mm</p>
                <p><strong>등록일:</strong> ${new Date(product.createdAt).toLocaleDateString()}</p>
                <p><strong>QR 코드:</strong></p>
                <img src="${qrCodeURL}" alt="QR 코드" />
                <hr/>
                <div id="stockLogDetails" style="margin-top: 20px;"></div> <!-- 로그 정보 공간 -->
            `;

            const stockLogDetails = document.getElementById("stockLogDetails");

            // 로그 정보를 생성
            if (stockLogs.length > 0) {
                let logMessages = '';
                stockLogs.forEach((log, index) => {
                    const logNumber = index + 1; // 1부터 시작하는 순서
                    if (log.outboundId) {
                        logMessages += `<p>${logNumber}번째 로그: ${log.quantity}개의 재고가 ${new Date(log.createdAt).toLocaleDateString()}에 출고되었습니다.</p>`;
                    } else if (log.inboundId) {
                        logMessages += `<p>${logNumber}번째 로그: ${log.quantity}개의 재고가 ${new Date(log.createdAt).toLocaleDateString()}에 입고되었습니다.</p>`;
                    }
                });
                stockLogDetails.innerHTML = logMessages;
            } else {
                stockLogDetails.innerHTML = `<p>로그 정보가 없습니다.</p>`;
            }
        }

        // QR 코드 URL 생성 함수
        function generateQRCodeURL(product) {
            const productData = JSON.stringify(product);
            const encodedData = encodeURIComponent(productData);
            return `https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=${encodedData}`;
        }

        const paginationUl = document.querySelector(".pagination");
        paginationUl.innerHTML = "";

        let pagination = jsonData.pages;

        console.log(pagination.totalPages);

        let end = Math.ceil(pagination.number <= 0 ? 1 : pagination.number / 10.0) * 10;
        console.log(end);

        end = end > pagination.totalPages ? pagination.totalPages : end;

        let start = end - 9;
        start = start <= 0 ? 1 : start;

        console.log("start " + start);
        console.log("end " + end);

        // "이전" 버튼
        let prevLi = document.createElement("li");
        prevLi.classList.add("page-item");
        if (pagination.number === 0) {
            prevLi.classList.add("disabled");
        }
        let prevA = document.createElement("a");
        prevA.classList.add("page-link");
        prevA.innerHTML = "Previous";
        prevA.onclick = function (event) {
            event.preventDefault();
            if (pagination.number > 0) {
                request(pagination.number - 1);
            }
        };
        prevLi.appendChild(prevA);
        paginationUl.appendChild(prevLi);

        for (let i = start; i <= end; i++) {
            let li = document.createElement("li")
            li.classList.add("page-item");

            if (i - 1 === pagination.number) {
                li.classList.add("disabled"); // 현재 페이지 비활성화
            }

            let a = document.createElement("a");
            a.classList.add("page-link")
            a.setAttribute("onclick", `request(${i - 1})`);
            a.innerHTML = i;

            li.appendChild(a);
            paginationUl.appendChild(li);
        }

        // "다음" 버튼
        let nextLi = document.createElement("li");
        nextLi.classList.add("page-item");
        if (pagination.number === pagination.totalPages - 1) {
            nextLi.classList.add("disabled");
        }
        let nextA = document.createElement("a");
        nextA.classList.add("page-link");
        nextA.innerHTML = "Next";
        nextA.onclick = function (event) {
            event.preventDefault();
            if (pagination.number < pagination.totalPages - 1) {
                request(pagination.number + 1);
            }
        };
        nextLi.appendChild(nextA);
        paginationUl.appendChild(nextLi);

    }

    request(0);

    // 모달에 재고 상세정보 표시
    function showStockDetails(stock) {
        const modalContent = document.getElementById("modalStockDetails");
        modalContent.innerHTML = `
        <strong>ID:</strong> ${stock.id}<br>
        <strong>재고 수량:</strong> ${stock.quantity}<br>
        <strong>생성일:</strong> ${new Date(stock.createdAt).toLocaleString()}<br>
        <strong>입고 ID:</strong> ${stock.inboundId || '없음'}<br>
        <strong>출고 ID:</strong> ${stock.outboundId || '없음'}<br>
    `;
        $('#stockDetailModal').modal('show'); // jQuery 사용하여 모달 표시
    }
})