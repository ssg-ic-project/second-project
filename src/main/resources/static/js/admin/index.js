document.addEventListener("DOMContentLoaded", () => {
  let selects = document.querySelectorAll(".select");
  let optionLists = document.querySelectorAll(".option-list");

  selects.forEach((select, index) => {
    let optionList = optionLists[index];
    let options = optionList.querySelectorAll(".option");

    select.addEventListener("click", () => {
      optionList.classList.toggle("active");
    });

    options.forEach((option) => {
      option.addEventListener("click", () => {
        options.forEach((opt) => {
          opt.classList.remove('selected');
        });

        select.querySelector("span").innerText = option.innerHTML;
        option.classList.add("selected");

        optionList.classList.remove("active");
      });
    });
  });

  document.addEventListener("click", (event) => {
    if (!event.target.closest(".select-menu")) {
      optionLists.forEach(optionList => {
        optionList.classList.remove("active");
      });
    }
  });
});
