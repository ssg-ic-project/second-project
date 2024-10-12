document.addEventListener('DOMContentLoaded', function () {
  let adminRole = '';
  let id = '';

  async function adminDetail(adminId) {

    const response = await fetch(`/api/admin?id=${adminId}`);
    const jsonData = await response.json();
    const data = jsonData.data;

    const nameElements = document.getElementsByName("name");
    for (let i = 0; i < nameElements.length; i++) {
      nameElements[i].textContent = data.name;
    }

    document.getElementById("id").textContent = data.id;
    document.getElementById("name").textContent = data.name;
    document.getElementById("username").textContent = data.username;
    document.getElementById("companyEmail").textContent = data.companyEmail;
    document.getElementById("warehouseName").textContent = data.warehouseName;
    document.getElementById("role").textContent = data.role;
    document.getElementById("phone").textContent = data.phone;
    document.getElementById("createdAt").textContent = data.createdAt;
    document.getElementById("updatedAt").textContent = data.updatedAt;

    adminRole = data.role;
    id = data.id;

    highlightSelectedRole(adminRole);
  }

  adminDetail(adminId);

  function highlightSelectedRole(selectedRole) {
    const options = document.querySelectorAll('.option');
    options.forEach(option => {
      option.classList.toggle('selected',
          option.dataset.value === selectedRole);
    });
  }

  document.getElementById("btn-modify").addEventListener("click",
    async function () {
      const selectedRole = document.querySelector(
          '.option.selected')?.dataset.value || "";

      const response = await fetch('/api/admin', {
        method: 'PATCH', // PATCH 메서드
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          requestDTO: {
            id: id,
            role: selectedRole
          }
        })
      });

      location.reload(); // 페이지 새로 고침

      // if (response.ok) {
      //   const result = await response.json();
      //   alert('수정되었습니다: ' + result.message);
      //   location.reload();
      // } else {
      //   alert('수정 실패: ' + response.statusText);
      // }
    });

  const selectRole = document.getElementById("select-role");
  const select = document.getElementById("select");
  const optionList = document.getElementById("role-list");

  select.addEventListener("click", () => {
    selectRole.classList.toggle("active");
  });

  optionList.querySelectorAll(".option").forEach((option) => {
    option.addEventListener("click", () => {
      optionList.querySelectorAll(".option").forEach((opt) => {
        opt.classList.remove("selected");
      });

      select.querySelector("span").innerText = option.innerHTML;
      option.classList.add("selected");
      selectRole.classList.remove("active");
    });
  });

  // 클릭 외부 시 메뉴 닫기
  document.addEventListener("click", (event) => {
    if (!event.target.closest(".select-menu")) {
      selectRole.classList.remove("active");
    }
  });
});