document.addEventListener("DOMContentLoaded", () => {
  const sizeMenu = document.getElementById("table-size");
  const sizeSelect = document.getElementById("table-size-select");
  const sizeOptionList = document.getElementById("size-option-list");

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

  const sortMenu = document.getElementById("table-sort");
  const sortSelect = document.getElementById("table-sort-select");
  const sortOptionList = document.getElementById("sort-option-list");

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
});
