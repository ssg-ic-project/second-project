let latitude, longitude;
document.addEventListener('DOMContentLoaded', () => {
    const id = document.getElementById('id');
    const name = document.getElementById('name');
    const adminId = document.getElementById('adminId');
    const size = document.getElementById('size');
    const capacity = document.getElementById('capacity');
    const createdAt = document.getElementById('createdAt');
    const address = document.getElementById('address');
    longitude = document.getElementById('latitude');
    latitude = document.getElementById('longitude');

    const modalName = document.querySelector('.name');
    const modalAdminId = document.querySelector('.adminId');
    const modalSize = document.querySelector('.size');
    const modalCapacity = document.querySelector('.capacity');
    const modalAddress = document.querySelector('.address');

    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
            level: 3 // 지도의 확대 레벨
        };

    fetch(`/api/warehouse/${warehouse_id}`)
        .then(res => res.json())
        .then(data => {
            console.log(data);

            id.textContent = data.warehouseDTO.id;
            name.textContent = data.warehouseDTO.name;
            adminId.textContent = data.warehouseDTO.adminId;
            size.textContent = `${data.warehouseDTO.size} ㎥`;
            capacity.textContent = `${data.warehouseDTO.capacity} 개`;
            createdAt.textContent = data.warehouseDTO.createdAt;
            address.textContent = data.warehouseDTO.address;
            longitude.value = data.warehouseDTO.longitude;
            latitude.value = data.warehouseDTO.latitude;

            console.log(latitude);
            console.log(latitude.value);
            console.log(longitude);
            console.log(longitude.value);

            modalName.value = name.textContent;
            modalAdminId.value = adminId.textContent;
            modalSize.value = size.textContent;
            modalCapacity.value = capacity.textContent;
            modalAddress.value = address.textContent;

            var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// HTML5의 geolocation으로 사용할 수 있는지 확인합니다
            if (navigator.geolocation) {

                var locPosition = new kakao.maps.LatLng(latitude.value, longitude.value), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
                    message = `<div style="white-space:nowrap; padding:5px;">${address.textContent}</div>`; // 인포윈도우에 표시될 내용입니다

                // 마커와 인포윈도우를 표시합니다
                displayMarker(locPosition, message);

            } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

                var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
                    message = 'geolocation을 사용할수 없어요..'

                displayMarker(locPosition, message);
            }

// 지도에 마커와 인포윈도우를 표시하는 함수입니다
            function displayMarker(locPosition, message) {

                // 마커를 생성합니다
                var marker = new kakao.maps.Marker({
                    map: map,
                    position: locPosition
                });

                var iwContent = message, // 인포윈도우에 표시할 내용
                    iwRemoveable = true;

                // 인포윈도우를 생성합니다
                var infowindow = new kakao.maps.InfoWindow({
                    content : iwContent,
                    removable : iwRemoveable
                });

                // 인포윈도우를 마커위에 표시합니다
                infowindow.open(map, marker);

                // 지도 중심좌표를 접속위치로 변경합니다
                map.setCenter(locPosition);
            }
        });

    document.getElementById('modifyBtn').addEventListener('click', function() {
        let modifyName = modalName.value;
        let modifySize = modalAdminId.value;
        let modifyCapacity = modalCapacity.value;
        let modifyAddress = modalAddress.value;
        let latitude = document.getElementById('latitude').value;
        let longitude = document.getElementById('longitude').value;

        const data = {
            adminId: adminId.textContent,
            name: modifyName,
            size: parseInt(modifySize),
            capacity: parseInt(modifyCapacity),
            latitude: longitude,
            longitude: latitude,
            address: modifyAddress,
        };

        fetch(`/api/warehouse/${id.textContent}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('수정 실패');
            })
            .then(data => {
                alert(data.msg); // 성공 메시지 처리

                // window.location.href = `http://localhost:8080/warehouse/detail/${id.textContent}`;
                window.location.href = `http://localhost:8080/warehouse/detail/19`;
            })
            .catch(error => {
                console.error('Error:', error);
                alert('수정 중 오류가 발생했습니다.');
            });
    });

});

let geocoder, marker, mapDaum;

var modalContainer = document.querySelector('.map'), // 지도를 표시할 div
    daumMapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

//지도를 미리 생성
mapDaum = new daum.maps.Map(modalContainer, daumMapOption);

//주소-좌표 변환 객체를 생성
geocoder = new daum.maps.services.Geocoder();

//마커를 미리 생성
marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    map: mapDaum
})

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = data.address; // 최종 주소 변수

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("sample5_address").value = addr;
            // 주소로 상세 정보를 검색
            geocoder.addressSearch(data.address, function(results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === daum.maps.services.Status.OK) {

                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    var coords = new daum.maps.LatLng(result.y, result.x);

                    document.getElementById('latitude').value = result.x;
                    document.getElementById('longitude').value = result.y;

                    modalContainer.style.display = "block";
                    mapDaum.relayout();
                    // 지도 중심을 변경한다.
                    mapDaum.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords)
                }
            });
        }
    }).open();
}

