async function inboundDetail(inboundId) {
  const response = await fetch(`/api/inbound?id=${inboundId}`);
  const jsonData = await response.json();
  const inbound = jsonData.data.inbound;
  const approvalList = jsonData.data.approvalList;

  console.log(JSON.stringify(inbound, null, 2));
  console.log("id: " + inbound.id);

  document.getElementById("id").textContent = inbound.id;
  document.getElementById("expectedDate").textContent = inbound.expectedDate;
  document.getElementById("quantity").textContent = inbound.quantity;
  document.getElementById("createdAt").textContent = inbound.createdAt;
  document.getElementById("updatedAt").textContent = inbound.updatedAt;
  document.getElementById("userId").textContent = inbound.userId;
  document.getElementById("userName").textContent = inbound.userName;
  document.getElementById("companyName").textContent = inbound.companyName;
  document.getElementById("userEmail").textContent = inbound.userEmail;
  document.getElementById("userPhone").textContent = inbound.userPhone;
  document.getElementById("warehouseId").textContent = inbound.warehouseId;
  document.getElementById("warehouseName").textContent = inbound.warehouseName;
  document.getElementById("sectionName").textContent = inbound.sectionName;
  document.getElementById("cellName").textContent = inbound.cellName;
  document.getElementById("stock").textContent = inbound.stock;
  document.getElementById("productId").textContent = inbound.productId;
  document.getElementById("productName").textContent = inbound.productName;
  document.getElementById("category").textContent = inbound.mainCategory + ' > ' + inbound.subCategory + ' > ' + inbound.detailCategory;
  document.getElementById("productHeight").textContent = inbound.productHeight + ' (mm)';
  document.getElementById("productWidth").textContent = inbound.productWidth + ' (mm)';
  document.getElementById("productDepth").textContent = inbound.productDepth + ' (mm)';

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