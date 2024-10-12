document.addEventListener('DOMContentLoaded', function () {
  let id = '';

  async function userDetail(userId) {
    id = userId;

    const response = await fetch(`/api/user?id=${userId}`);
    const jsonData = await response.json();
    const data = jsonData.data;

    const nameElements = document.getElementsByName("name");
    for (let i = 0; i < nameElements.length; i++) {
      nameElements[i].textContent = data.name;
    }

    const companyElements = document.getElementsByName("companyName");
    for (let i = 0; i < companyElements.length; i++) {
      companyElements[i].textContent = data.companyName;
    }

    document.getElementById("id").textContent = data.id;
    document.getElementById("name").textContent = data.name;
    document.getElementById("username").textContent = data.username;
    document.getElementById("email").textContent = data.email;
    document.getElementById("phone").textContent = data.phone;
    document.getElementById("created-at").textContent = data.createdAt;
    document.getElementById("updated-at").textContent = data.updatedAt;
    document.getElementById(
        "business-number").textContent = data.businessNumber;
    document.getElementById("company-name").textContent = data.companyName;
    document.getElementById("zip-code").textContent = data.zipCode;
    document.getElementById("address").textContent = data.address;
    document.getElementById("is-unregister").textContent = data.isUnregister
    === true
        ? 'O' : 'X';
    document.getElementById(
        "unregister-reason").textContent = data.unregisterReason;
    document.getElementById(
        "unregistered-at").textContent = data.unregisteredAt;
    document.getElementById("comment").textContent = data.comment;

    document.getElementById(
        "modify-unregister-reason").value = data.unregisterReason;

  }

  async function userApprovalList(userId) {
    const response = await fetch(`/api/user/approval/list?userId=${userId}`);
    const jsonData = await response.json();
    const dataList = jsonData.dataList || [];

    const tbody = document.querySelector("#approval-list tbody");

    dataList.forEach(data => {
      const row = document.createElement('tr');
      row.innerHTML = `
      <td>${data.status ? data.status : '-'}</td>
      <td>${data.rejectionReason ? data.rejectionReason : '-'}</td>
      <td>${data.createdAt ? data.createdAt : '-'}</td>
    `;
      tbody.appendChild(row);
    });
  }

  userDetail(userId);
  userApprovalList(userId);

  document.getElementById("btn-approve").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/user/approval/status', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            id: id,
            status: 'APPROVED'
          })
        });

        location.reload();
      });

  document.getElementById("btn-reject").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/user/approval/status', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            id: id,
            status: 'REJECTED',
            rejectionReason: document.getElementById("rejection-reason").value
          })
        });

        location.reload();
      });

  document.getElementById("btn-remove").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/user/unregister', {
          method: 'PATCH',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            id: id,
            isUnregister: true,
            unregisterReason: document.getElementById(
                "modify-unregister-reason").value
          })
        });

        location.reload();
      });

  const textareas = document.querySelectorAll(".modal-body textarea");
  textareas.forEach(textarea => {
    textarea.addEventListener("input", function () {
      this.style.height = this.scrollHeight + 'px';
    });
  });
});