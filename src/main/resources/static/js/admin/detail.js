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
}