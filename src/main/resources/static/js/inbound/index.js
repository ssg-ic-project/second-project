async function inboundList() {
  const response = await fetch(`/api/inbound/list`);

  const jsonData = await response.json();
  const approvalList = jsonData.data.inboundList;

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

document.addEventListener('DOMContentLoaded', function() {
  const today = new Date();
  const startDateDefault = new Date();
  startDateDefault.setDate(today.getDate() - 30);

  flatpickr("#start-date", {
    dateFormat: "Y-m-d",
    defaultDate: startDateDefault,
    onClose: function(selectedDates) {
      const startDate = selectedDates[0];
      if (startDate) {
        endPicker.set('minDate', startDate);
      }
    }
  });

  const endPicker = flatpickr("#end-date", {
    dateFormat: "Y-m-d",
    defaultDate: today,
    minDate: startDateDefault
  });

  document.getElementById('start-date').value = startDateDefault.toISOString().split('T')[0];
  document.getElementById('end-date').value = today.toISOString().split('T')[0];
});