async function adminDetail(adminId) {
  const response = await fetch(`/api/admin?id=${adminId}`);
  const jsonData = await response.json();
  const admin = jsonData.data.admin;

  const nameElements = document.getElementsByName("name");
  for (let i = 0; i < nameElements.length; i++) {
    nameElements[i].textContent = admin.name;
  }
  
  document.getElementById("id").value = admin.id;
  document.getElementById("name").value = admin.name;
  document.getElementById("adminId").value = admin.adminId;
  document.getElementById("email").value = admin.email;
  document.getElementById("role").value = admin.role;
  document.getElementById("department").value = admin.department;
  document.getElementById("position").value = admin.position;
  document.getElementById("phone").value = admin.phone;
  document.getElementById("createdAt").value = admin.createdAt;
  document.getElementById("updatedAt").value = admin.updatedAt;
}