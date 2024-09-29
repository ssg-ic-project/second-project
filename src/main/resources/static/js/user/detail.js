async function userDetail(userId) {
  const response = await fetch(`/api/user?id=${userId}`);
  const jsonData = await response.json();
  const user = jsonData.data.user;
  const approvalList = jsonData.data.approvalList;

  const nameElements = document.getElementsByName("name");
  for (let i = 0; i < nameElements.length; i++) {
    nameElements[i].textContent = user.name;
  }

  const companyElements = document.getElementsByName("companyName");
  for (let i = 0; i < companyElements.length; i++) {
    companyElements[i].textContent = user.companyName;
  }

  document.getElementById("id").textContent = user.id;
  document.getElementById("name").textContent = user.name;
  document.getElementById("userId").textContent = user.userId;
  document.getElementById("email").textContent = user.email;
  document.getElementById("phone").textContent = user.phone;
  document.getElementById("createdAt").textContent = user.createdAt;
  document.getElementById("updatedAt").textContent = user.updatedAt;
  document.getElementById("businessNumber").textContent = user.businessNumber;
  document.getElementById("companyName").textContent = user.companyName;
  document.getElementById("zipCode").textContent = user.zipCode;
  document.getElementById("address").textContent = user.address;
  document.getElementById("isUnregister").textContent = user.isUnregister;
  document.getElementById("unregisterAt").textContent = user.unregisterAt;

  document.getElementById("modifyCompanyName").value = user.companyName;
  document.getElementById("modicyBusinessNumber").value = user.businessNumber;
  // let businessNumber = document.getElementById("modicyBusinessNumber").value;

  const tbody = document.querySelector("#approval-list tbody");

  approvalList.forEach(approval => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${approval.status ? approval.status : '-'}</td>
      <td>${approval.rejectionReason ? approval.rejectionReason : '-'}</td>
      <td>${approval.createdAt ? approval.createdAt : '-'}</td>
    `;
    tbody.appendChild(row);
  });
}