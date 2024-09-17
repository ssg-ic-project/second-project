document.addEventListener("DOMContentLoaded", () => {
  let arrow = document.querySelectorAll(".nav-arrow");
  for (let i = 0; i < arrow.length; i++) {
    arrow[i].addEventListener("click", (e) => {
      let arrowParent = e.target.closest(".nav-menu");
      arrowParent.classList.toggle("showMenu");
    });
  }

  let sidebar = document.querySelector(".sidebar");
  let sidebarBtn = document.querySelector(".show");
  let mainContent = document.querySelector(".main-content")
  sidebarBtn.addEventListener("click", () => {
    sidebar.classList.toggle("close");

    if (sidebar.classList.contains('close')) {
      mainContent.style.marginLeft = '55px';
    } else {
      mainContent.style.marginLeft = '220px';
    }
  });

});
