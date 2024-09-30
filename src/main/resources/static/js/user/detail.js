async function userDetail(userId) {
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
  document.getElementById("createdAt").textContent = data.createdAt;
  document.getElementById("updatedAt").textContent = data.updatedAt;
  document.getElementById("businessNumber").textContent = data.businessNumber;
  document.getElementById("companyName").textContent = data.companyName;
  document.getElementById("zipCode").textContent = data.zipCode;
  document.getElementById("address").textContent = data.address;
  document.getElementById("isUnregister").textContent = data.isUnregister === 1 ? 'O' : 'X';
  document.getElementById("unregisterAt").textContent = data.unregisterAt;
  document.getElementById("comment").textContent = data.comment;

  document.getElementById("modifyCompanyName").value = data.companyName;
  document.getElementById("modicyBusinessNumber").value = data.businessNumber;

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