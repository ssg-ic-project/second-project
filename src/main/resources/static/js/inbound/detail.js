document.addEventListener('DOMContentLoaded', function () {

  let id = '';

  async function inboundDetail(inboundId) {
    id = inboundId;

    const response = await fetch(`/api/inbound?id=${inboundId}`);
    const jsonData = await response.json();
    const data = jsonData.data;

    document.getElementById("id").textContent = data.inboundId;
    document.getElementById("expected-date").textContent = data.expectedDate;
    document.getElementById("quantity").textContent = data.quantity;
    document.getElementById("created-at").textContent = data.createdAt;
    document.getElementById("updated-at").textContent = data.updatedAt;
    document.getElementById("warehouse-id").textContent = data.warehouseId;
    document.getElementById("warehouse-name").textContent = data.warehouseName;
    document.getElementById("section-name").textContent = data.sectionName;
    document.getElementById("cell-name").textContent = data.cellName;
    document.getElementById("stock-quantity").textContent = data.stockQuantity;
    document.getElementById("use-space").textContent = data.useSpace
        + ' m\u00B3';
    document.getElementById("free-space").textContent = data.freeSpace
        + ' m\u00B3';
    document.getElementById("product-id").textContent = data.productId;
    document.getElementById("product-name").textContent = data.productName;
    document.getElementById("category").textContent = data.mainCategory + ' > '
        + data.subCategory + ' > ' + data.detailCategory;
    document.getElementById("product-height").textContent = data.productHeight
        + ' (mm)';
    document.getElementById("product-width").textContent = data.productWidth
        + ' (mm)';
    document.getElementById("product-depth").textContent = data.productDepth
        + ' (mm)';
    document.getElementById("user-id").textContent = data.userId;
    document.getElementById("user-name").textContent = data.userName;
    document.getElementById("company-name").textContent = data.companyName;
    document.getElementById("user-email").textContent = data.userEmail;
    document.getElementById("user-phone").textContent = data.userPhone;

    document.getElementById("modify-expected-date").value = data.expectedDate;
    document.getElementById("modify-quantity").value = data.quantity;

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
          id: id,
          status: 'REJECTED',
          rejectionReason: document.getElementById("rejection-reason").value
        })
      });

      location.reload();
    });
});