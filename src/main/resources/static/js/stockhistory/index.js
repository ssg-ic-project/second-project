document.addEventListener("DOMContentLoaded", () => {
    window.request = async function(page) {
        const response = await fetch(`/api/stockhistory/list?page=${page}`);
        const jsonData = await response.json();

        const tableBody = document.getElementById("stockTableBody");
        tableBody.innerHTML = "";

        // jsonData.pages.content에서 데이터를 가져옴
        const stocks = jsonData.pages.content;

        console.log(stocks);

        // 각 창고 정보를 테이블에 추가
        stocks.forEach(stock => {
            const row = document.createElement("tr");

            // 재고 타입 결정
            let stockType = '';
            if (stock.inboundId === null) {
                stockType = '출고 재고';
            } else if (stock.outboundId === null) {
                stockType = '입고 재고';
            }

            // 상세보기 버튼 생성
            const detailButton = document.createElement("button");
            detailButton.setAttribute("type", "button");
            detailButton.setAttribute("data-bs-toggle", "modal");
            detailButton.setAttribute("data-bs-target", "#exampleModal");

            detailButton.className = "btn btn-info";
            detailButton.textContent = "상세보기";
            // detailButton.onclick = () => showStockDetails(stock);

            row.innerHTML = `
                <th scope="row">${stock.id}</th>
                <td>${stockType}</td>
                <td>${stock.quantity}</td>
                <td>${new Date(stock.createdAt).toLocaleDateString()}</td>
                <td></td>
            `;

            // 상세보기 버튼을 행에 추가
            row.cells[4].appendChild(detailButton);
            tableBody.appendChild(row);
        });

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