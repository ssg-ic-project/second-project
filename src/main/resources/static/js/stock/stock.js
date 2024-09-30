document.getElementById('registerBtn').addEventListener('click', function() {
    const name = document.getElementById('title').value;
    const size = document.getElementById('size').value;
    const capacity = document.getElementById('capacity').value;
    const address = document.getElementById('sample5_address').value;
    const longitude = document.getElementById('longitude').value;
    const latitude = document.getElementById('latitude').value;

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

            window.location.href = "http://localhost:8080/warehouse/index";
        })
        .catch(error => {
            console.error('Error:', error);
            alert('등록 중 오류가 발생했습니다.');
        });
});