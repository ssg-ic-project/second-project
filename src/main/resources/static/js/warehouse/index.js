document.addEventListener("DOMContentLoaded", async () => {
    var positions = [];

    const response = await fetch("/api/warehouse?page=1");
    const jsonData = await response.json();

    console.log(jsonData);

    const tableBody = document.getElementById("warehouseTableBody");

    // jsonData.pages.content에서 데이터를 가져옴
    const warehouses = jsonData.pages.content;

    console.log(warehouses);

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

    // 중간 데이터의 위도 및 경도 얻기
    const midIndex = Math.floor(warehouses.length / 2);
    const midWarehouse = warehouses[midIndex];

    var markerMapContainer = document.querySelector('.map'), // 지도를 표시할 div
        markerMapOption = {
            center: new kakao.maps.LatLng(midWarehouse.latitude, midWarehouse.longitude), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
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
})
