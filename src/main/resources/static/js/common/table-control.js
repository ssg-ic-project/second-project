document.addEventListener("DOMContentLoaded", () => {
  // table-size select menu 처리
  const sizeSelect = document.getElementById("table-size-select");
  const sizeOptionList = document.getElementById("size-option-list");
  const sizeMenu = document.getElementById("table-size");

  sizeSelect.addEventListener("click", () => {
    sizeMenu.classList.toggle("active");
  });

  sizeOptionList.querySelectorAll(".table-controls .option").forEach((option) => {
    option.addEventListener("click", () => {
      sizeOptionList.querySelectorAll(".table-controls .option").forEach((opt) => {
        opt.classList.remove("selected");
      });

      sizeSelect.querySelector("span").innerText = option.innerHTML;
      option.classList.add("selected");
      sizeMenu.classList.remove("active");
    });
  });

  // table-sort select menu 처리
  const sortSelect = document.getElementById("table-sort-select");
  const sortOptionList = document.getElementById("sort-option-list");
  const sortMenu = document.getElementById("table-sort");

  sortSelect.addEventListener("click", () => {
    sortMenu.classList.toggle("active");
  });

  sortOptionList.querySelectorAll(".table-controls .option").forEach((option) => {
    option.addEventListener("click", () => {
      sortOptionList.querySelectorAll(".table-controls .option").forEach((opt) => {
        opt.classList.remove("selected");
      });

      sortSelect.querySelector("span").innerText = option.innerHTML;
      option.classList.add("selected");
      sortMenu.classList.remove("active");
    });
  });

  // // 클릭 외부 시 모든 메뉴 닫기
  // document.addEventListener("click", (event) => {
  //   if (!event.target.closest(".select-menu")) {
  //     document.querySelectorAll(".select-menu").forEach(menu => {
  //       menu.classList.remove("active");
  //     });
  //   }
  // });
});
