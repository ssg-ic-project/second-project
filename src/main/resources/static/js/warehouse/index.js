document.addEventListener('DOMContentLoaded', function() {
    //
    // var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
    //
    // console.log(
    //     kakao
    // )
    // console.log(container);
    // var options = { //지도를 생성할 때 필요한 기본 옵션
    //     center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
    //     level: 3 //지도의 레벨(확대, 축소 정도)
    // };
    //
    // console.log(options);
    //
    // var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
    // console.log(map);
    //
    //
});

var mapContainer = document.getElementById('map1'), // 지도를 표시할 div
    mapOption = {
        center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

//지도를 미리 생성
var map = new daum.maps.Map(mapContainer, mapOption);

console.log(map);
//주소-좌표 변환 객체를 생성

var geocoder = new daum.maps.services.Geocoder();
//마커를 미리 생성
var marker = new daum.maps.Marker({
    position: new daum.maps.LatLng(37.537187, 127.005476),
    map: map
});

function sample5_execDaumPostcode() {
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

                    // 지도를 보여준다.
                    mapContainer.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords)
                }
            });
        }
    }).open();
}

document.getElementById('registerBtn').addEventListener('click', function() {
    const name = document.getElementById('title').value;
    const size = document.getElementById('size').value;
    const capacity = document.getElementById('capacity').value;
    const address = document.getElementById('sample5_address').value;
    const longitude = document.getElementById('longitude').value;
    const latitude = document.getElementById('latitude').value;

    console.log(longitude);
    console.log(latitude);

    // 데이터 유효성 검사
    if (!name || !size || !capacity || !address) {
        alert("모든 필드를 입력해 주세요.");
        return;
    }

    const data = {
        adminId: 1,
        name: name,
        size: parseInt(size),
        capacity: parseInt(capacity),
        latitude: longitude,
        longitude: latitude,
        address: address
    };

    fetch('/api/warehouse', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                return response.json();
            }
            throw new Error('등록 실패');
        })
        .then(data => {
            alert(data.msg); // 성공 메시지 처리
            const modalElement = document.getElementById('exampleModal');
            const modal = bootstrap.Modal.getInstance(modalElement) || new bootstrap.Modal(modalElement);
            modal.hide(); // 모달 닫기
        })
        .catch(error => {
            console.error('Error:', error);
            alert('등록 중 오류가 발생했습니다.');
        });
});
