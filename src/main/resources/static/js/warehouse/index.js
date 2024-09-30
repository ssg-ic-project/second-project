document.addEventListener("DOMContentLoaded", () => {
    var positions = [];

    window.request = async function(page) {
        const response = await fetch(`/api/warehouse?page=${page}`);
        const jsonData = await response.json();

        const tableBody = document.getElementById("warehouseTableBody");
        tableBody.innerHTML = "";

        // jsonData.pages.content에서 데이터를 가져옴
        const warehouses = jsonData.pages.content;

        // 각 창고 정보를 테이블에 추가
        warehouses.forEach(warehouse => {
            positions.push({
                title: warehouse.name,
                latlng: new kakao.maps.LatLng(warehouse.latitude, warehouse.longitude)
            })

            const row = document.createElement("tr");

            row.innerHTML = `
            <th scope="row">
                <a href="/warehouse/detail/${warehouse.id}">
                    ${warehouse.id}</th>
                </a>
            <td>
                ${warehouse.name}
            </td>
            <td>${warehouse.size}</td>
            <td>${warehouse.capacity}</td>
            <td>${warehouse.address}</td>
            <td>${new Date(warehouse.createdAt).toLocaleDateString()}</td>
        `;

            tableBody.appendChild(row);
        });

        const paginationUl = document.querySelector(".pagination");
        paginationUl.innerHTML = "";

        let pagination = jsonData.pages;

        let end = Math.ceil(pagination.number <= 0 ? 1 : pagination.number / 10.0) * 10;

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
        prevA.onclick = function(event) {
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
        nextA.onclick = function(event) {
            event.preventDefault();
            if (pagination.number < pagination.totalPages - 1) {
                request(pagination.number + 1);
            }
        };
        nextLi.appendChild(nextA);
        paginationUl.appendChild(nextLi);

        // 중간 데이터의 위도 및 경도 얻기
        const midIndex = Math.floor(warehouses.length / 2);
        const midWarehouse = warehouses[midIndex];

        var markerMapContainer = document.querySelector('.map'), // 지도를 표시할 div
            markerMapOption = {
                center: new kakao.maps.LatLng(midWarehouse.latitude, midWarehouse.longitude), // 지도의 중심좌표
                level: 14 // 지도의 확대 레벨
            };

        var markerMap = new kakao.maps.Map(markerMapContainer, markerMapOption); // 지도를 생성합니다


        // 마커 이미지의 이미지 주소입니다
        var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

        for (var i = 0; i < positions.length; i ++) {

            // 마커 이미지의 이미지 크기 입니다
            var imageSize = new kakao.maps.Size(24, 35);

            // 마커 이미지를 생성합니다
            var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            // 마커를 생성합니다
            var marker = new kakao.maps.Marker({
                map: markerMap, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
                title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                image : markerImage // 마커 이미지
            });

            marker.setMap(markerMap);
        }
    }

    request(0);
})