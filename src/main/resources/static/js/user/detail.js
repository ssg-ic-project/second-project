async function userDetail(userId) {
  const response = await fetch(`/api/user?id=${userId}`);
  const jsonData = await response.json();
  const user = jsonData.data.user;

  const nameElements = document.getElementsByName("name");
  for (let i = 0; i < nameElements.length; i++) {
    nameElements[i].textContent = user.name;
  }

  document.getElementById("id").textContent = user.id;
  document.getElementById("name").textContent = user.name;
  document.getElementById("userId").textContent = user.userId;
  document.getElementById("businessNumber").textContent = user.businessNumber;
  document.getElementById("email").textContent = user.email;
  document.getElementById("phone").textContent = user.phone;
  document.getElementById("companyName").textContent = user.companyName;
  document.getElementById("zipCode").textContent = user.zipCode;
  document.getElementById("address").textContent = user.address;
  document.getElementById("isUnregister").textContent = user.isUnregister;
  document.getElementById("createdAt").textContent = user.createdAt;
  document.getElementById("updatedAt").textContent = user.updatedAt;
  document.getElementById("unregisterAt").textContent = user.unregisterAt;
}