async function inboundList() {
  const response = await fetch(`/api/inbound/list`);

  const jsonData = await response.json();
  const approvalList = jsonData.data.inboundList;

  console.log("approvalList\n" + JSON.stringify(approvalList))

  const tbody = document.querySelector("#inbound-list tbody");

  approvalList.forEach(inbound => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td><a href="/inbound?id=${inbound.id}">${inbound.id ? inbound.id : '-'}</a></td>
      <td><a href="/user?id=${inbound.userId}">${inbound.userName
        ? inbound.userName : '-'}</a></td>
      <td>${inbound.productName ? inbound.productName : '-'}</td>
      <td>${inbound.cellId ? inbound.cellId : '-'}</td>
      <td>${inbound.expectedDate ? inbound.expectedDate : '-'}</td>
      <td>${inbound.quantity ? inbound.quantity : '-'}</td>
      <td>${inbound.approvalStatus ? inbound.approvalStatus : '-'}</td>
      <td>${inbound.createdAt ? inbound.createdAt : '-'}</td>
    `;
    tbody.appendChild(row);
  });
};
