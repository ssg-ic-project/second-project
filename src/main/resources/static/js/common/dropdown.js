document.addEventListener("DOMContentLoaded", () => {
  let selectMenus = document.querySelectorAll(".search-box .select-menu");
  let selects = document.querySelectorAll(".search-box .select");
  let optionLists = document.querySelectorAll(".search-box .option-list");

  selects.forEach((select, index) => {
    let optionList = optionLists[index];
    let selectMenu = selectMenus[index];
    let options = optionList.querySelectorAll(".search-box .option");

    select.addEventListener("click", () => {
       selectMenus.forEach(menu => {
        if (menu !== selectMenu) {
          menu.classList.remove("active");
        }
      });
      selectMenu.classList.toggle("active");
    });

    options.forEach((option) => {
      option.addEventListener("click", () => {
        options.forEach((opt) => {
          opt.classList.remove('selected');
        });

        select.querySelector("span").innerText = option.innerHTML;

        option.classList.add("selected");

        selectMenu.classList.remove("active");
      });
    });
  });

  // 클릭 외부 시 메뉴 닫기
  document.addEventListener("click", (event) => {
    if (!event.target.closest(".select-menu")) {
      selectMenus.forEach(selectMenu => {
        selectMenu.classList.remove("active");
      });
    }
  });
});
