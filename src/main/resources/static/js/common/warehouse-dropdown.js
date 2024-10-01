document.addEventListener("DOMContentLoaded", () => {
  const dropdownList = document.getElementById("dropdown-list");
  const warehouseMenu = document.getElementById("warehouse-menu");
  const warehouseSelect = document.getElementById("warehouse-select");
  const warehouseDropdown = document.getElementById("warehouse-dropdown");
  const optionSearch = document.querySelector(".option-search input");
  let selectedValue = null;
  let dataList = [];

  async function warehouseList() {
    const response = await fetch(`/api/warehouse/names`);
    const jsonData = await response.json();
    dataList = jsonData.dataList || [];

    dropdownList.innerHTML = '';

    dataList.forEach((warehouse) => {
      createOptionElement(warehouse);
    });
  }

  function createOptionElement(warehouse) {
    const option = document.createElement("div");
    option.setAttribute("data-value", warehouse.id);
    option.textContent = warehouse.name;
    option.classList.add("option");

    // 선택된 값 표시
    if (warehouse.id === selectedValue) {
      option.classList.add("selected");
    }

    // 옵션 클릭 이벤트 추가
    option.addEventListener("click", (event) => {
      event.stopPropagation(); // 다른 클릭 핸들러의 실행 방지

      const selectedSpan = warehouseSelect.querySelector("span");

      // 모든 옵션에서 'selected' 클래스 제거
      dropdownList.querySelectorAll('.option').forEach(opt => {
        opt.classList.remove('selected');
      });

      // 선택된 옵션에 'selected' 클래스 추가
      option.classList.add('selected');

      // 선택된 값으로 텍스트 업데이트 및 값 저장
      if (selectedSpan) {
        selectedSpan.innerText = option.innerHTML;
      }
      selectedValue = warehouse.id;

      // 드롭다운 닫기
      warehouseDropdown.classList.remove("show");
      warehouseMenu.classList.remove("active");
    });

    dropdownList.appendChild(option);
  }

  warehouseList();

  // 드롭다운 토글 기능
  warehouseSelect.addEventListener("click", () => {
    warehouseDropdown.classList.toggle("show");
  });

  // 드롭다운 외부 클릭 시 닫기
  window.addEventListener("click", (event) => {
    if (!warehouseSelect.contains(event.target) && !warehouseDropdown.contains(event.target)) {
      warehouseDropdown.classList.remove("show");
    }
  });

  optionSearch.addEventListener("keyup", () => {
    const searchedValue = optionSearch.value.toLowerCase();

    // data 배열을 필터링합니다.
    const result = dataList.filter(warehouse =>
      warehouse.name.toLowerCase().includes(searchedValue)
    );

    // 결과를 HTML로 변환
    dropdownList.innerHTML = '';

    if (result.length > 0) {
      result.forEach(warehouse => {
        createOptionElement(warehouse);
      });
    } else {
      dropdownList.innerHTML = `<p>No results found</p>`;
    }
  });
});
