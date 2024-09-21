async function adminDetail(adminId) {
  const response = await fetch(`/api/admin?id=${adminId}`);
  const jsonData = await response.json();
  const admin = jsonData.data.admin;

  const nameElements = document.getElementsByName("name");
  for (let i = 0; i < nameElements.length; i++) {
    nameElements[i].textContent = admin.name;
  }
  
  document.getElementById("id").textContent = admin.id;
  document.getElementById("name").textContent = admin.name;
  document.getElementById("adminId").textContent = admin.adminId;
  document.getElementById("email").textContent = admin.email;
  document.getElementById("role").textContent = admin.role;
  document.getElementById("department").textContent = admin.department;
  document.getElementById("position").textContent = admin.position;
  document.getElementById("phone").textContent = admin.phone;
  document.getElementById("createdAt").textContent = admin.createdAt;
  document.getElementById("updatedAt").textContent = admin.updatedAt;
}