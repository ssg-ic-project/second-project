document.addEventListener("DOMContentLoaded", () => {
  let selectMenus = document.querySelectorAll(".select-menu");
  let selects = document.querySelectorAll(".select");
  let optionLists = document.querySelectorAll(".option-list");

  selects.forEach((select, index) => {
    let optionList = optionLists[index];
    let selectMenu = selectMenus[index];
    let options = optionList.querySelectorAll(".option");

    select.addEventListener("click", () => {
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

  document.addEventListener("click", (event) => {
    if (!event.target.closest(".select-menu")) {
      selectMenus.forEach(selectMenu => {
        selectMenu.classList.remove("active");
      });
    }
  });
});
