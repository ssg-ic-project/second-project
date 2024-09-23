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

document.addEventListener('DOMContentLoaded', function() {
  const submitButton = document.getElementById('submit');
  if (submitButton) {
    submitButton.addEventListener('click', function() {
      const startDate = document.getElementById('start-date').value;
      const endDate = document.getElementById('end-date').value;

      if (startDate && endDate) {
        document.getElementById('selected-dates').innerText = `기간: ${startDate} ~ ${endDate}`;
      } else {
        alert('모든 날짜를 입력하세요.');
      }
    });
  } else {
    console.error('Submit button not found.');
  }
});