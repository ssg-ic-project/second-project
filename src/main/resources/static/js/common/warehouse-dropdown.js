document.addEventListener("DOMContentLoaded", () => {
  // 객체 생성
  const xhr = new XMLHttpRequest();
  let warehouseList;

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

      warehouseList = response.data.warehouseNameList;
      console.log("warehouseList: " + warehouseList);

      const warehouseSelect = document.getElementById("dropdown-list");

      warehouseList.forEach(function(warehouse) {
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

  const optionSearch = document.querySelector(".option-search input");
  const dropdownList = document.querySelector("#dropdown-list");

  optionSearch.addEventListener("keyup", () => {
    const searchedValue = optionSearch.value.toLowerCase();
    // console.log("검색: " + searchedValue);

    // data 배열을 필터링합니다.
    const result = warehouseList.filter(warehouse =>
        warehouse.name.toLowerCase().includes(searchedValue)
    );

    // 결과를 HTML로 변환
    const optionsHTML = result.map(warehouse =>
        `<div data-value="${warehouse.id}" class="option">${warehouse.name}</div>`
    ).join("");

    dropdownList.innerHTML = optionsHTML ? optionsHTML : `<p>No results found</p>`;
    // console.log("result: " + optionsHTML);
  });
});