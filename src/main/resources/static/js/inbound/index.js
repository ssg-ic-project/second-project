async function inboundList() {
  const page = 1; // 원하는 페이지 번호
  const size = 10; // 원하는 페이지 크기
  const orderBy = 'id'; // 원하는 정렬 기준
  const orderByDir = 'DESC'; // 정렬 방향
  const S = null; // 승인 상태 검색 조건
  const WH = null; // 상호명 검색 조건
  const SD = null; // Inbound createdAt start date 검색 조건
  const ED = null; // Inbound createdAt end date 검색 조건

  const response = await fetch(`/api/inbound/list?page=${page}&size=${size}&orderBy=${orderBy}&orderByDir=${orderByDir}&S=${S}&WH=${WH}&SD=${SD}&ED=${ED}`);

  const jsonData = await response.json();
  const dataList = jsonData.dataList || [];
  console.log(dataList);

  const tbody = document.querySelector("#inbound-list tbody");

  tbody.innerHTML = '';

  dataList.forEach(inbound => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td><a href="/inbound?id=${inbound.id}">${inbound.id ? inbound.id : '-'}</a></td>
      <td><a href="/user?id=${inbound.userId}">${inbound.userName
        ? inbound.userName : '-'}</a></td>
      <td>${inbound.productName ? inbound.productName : '-'}</td>
      <td>${inbound.cellId ? inbound.cellId : '-'}</td>
      <td>${inbound.expectedDate ? inbound.expectedDate : '-'}</td>
      <td>${inbound.quantity ? inbound.quantity : '-'}</td>
      <td>${inbound.status ? inbound.status : '-'}</td>
      <td>${inbound.createdAt ? inbound.createdAt : '-'}</td>
      <td>${inbound.approvedAt ? inbound.approvedAt : '-'}</td>
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