document.addEventListener('DOMContentLoaded', function () {

  let id = '';
  async function inboundDetail(inboundId) {
    id = inboundId;

    const response = await fetch(`/api/inbound?id=${inboundId}`);
    const jsonData = await response.json();
    const data = jsonData.data;

    document.getElementById("id").textContent = data.inboundId;
    document.getElementById("expectedDate").textContent = data.expectedDate;
    document.getElementById("quantity").textContent = data.quantity;
    document.getElementById("createdAt").textContent = data.createdAt;
    document.getElementById("updatedAt").textContent = data.updatedAt;
    document.getElementById("warehouseId").textContent = data.warehouseId;
    document.getElementById("warehouseName").textContent = data.warehouseName;
    document.getElementById("sectionName").textContent = data.sectionName;
    document.getElementById("cellName").textContent = data.cellName;
    document.getElementById("stockQuantity").textContent = data.stockQuantity;
    document.getElementById("useSpace").textContent = data.useSpace + ' m\u00B3';
    document.getElementById("freeSpace").textContent = data.freeSpace + ' m\u00B3';
    document.getElementById("productId").textContent = data.productId;
    document.getElementById("productName").textContent = data.productName;
    document.getElementById("category").textContent = data.mainCategory + ' > ' + data.subCategory + ' > ' + data.detailCategory;
    document.getElementById("productHeight").textContent = data.productHeight + ' (mm)';
    document.getElementById("productWidth").textContent = data.productWidth + ' (mm)';
    document.getElementById("productDepth").textContent = data.productDepth + ' (mm)';
    document.getElementById("userId").textContent = data.userId;
    document.getElementById("userName").textContent = data.userName;
    document.getElementById("companyName").textContent = data.companyName;
    document.getElementById("userEmail").textContent = data.userEmail;
    document.getElementById("userPhone").textContent = data.userPhone;

    document.getElementById("modifyExpectedDate").value = data.expectedDate;
    document.getElementById("modifyQuantity").value = data.quantity;

  }

  async function inboundApprovalList(inboundId) {
    const response = await fetch(
        `/api/inbound/approval/list?inboundId=${inboundId}`);

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


    inboundDetail(inboundId);
    inboundApprovalList(inboundId);

    document.getElementById("btn-approve").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/inbound/approval/status', {
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

    document.getElementById("btn-complete").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/inbound/approval/complete', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              id: id,
              status: 'COMPLETED'
          })
        });

        location.reload();
      });

    document.getElementById("btn-reject").addEventListener("click",
      async function () {
        const selectedRole = document.querySelector(
            '.option.selected')?.dataset.value || "";

        const response = await fetch('/api/inbound/approval/status', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
              inboundId: id,
              status: 'REJECTED',
            rejectionReason: document.getElementById("rejection-reason").value
          })
        });

        location.reload();
      });
});