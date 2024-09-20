document.addEventListener("DOMContentLoaded", () => {
  // 객체 생성
  const xhr = new XMLHttpRequest();

  /**
   * 서버에 요청하는 내장 함수 open()
   * open(HTTP Method, URL, 비동기 여부(default: true))
   */
  xhr.open('Get', '/api/warehouse/names');

  /**
   * setRequestHeader() 함수를 통해서 헤더값 설정
   * content-type 은 서버로 전송할 데이터의 MINE 타압
   * content-type 종류
   * 1. application/json: json 데이터 전송
   * 2. text/plain: text 데이터 전송
   * 3. multipart/from-data: 파일 전송
   */
  // xhr.setRequestHeader('content-type', 'application/json');

  xhr.onload = () => {
    if(xhr.status === 200) {
      const response = JSON.parse(xhr.response);
      console.log("data: " + response);

      const data = response.data.warehouses;

      const warehouseSelect = document.getElementById("warehouse-select");

      data.forEach(function(warehouse) {
        const option = document.createElement("div");
        option.setAttribute("data-value", warehouse.id);  // data-value 속성 추가
        option.textContent = warehouse.name;
        option.classList.add("option");  // class="option" 추가
        warehouseSelect.appendChild(option);  // 생성한 div를 container에 추가
      });
    } else {
      console.error(xhr.status, xhr.statusText);
    }
  };

  /**
   * send() 함수를 통해 요청 전송
   */
  xhr.send();
});