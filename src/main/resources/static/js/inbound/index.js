import {createPagination} from '/js/common/pagination.js';

document.addEventListener('DOMContentLoaded', function () {
  const today = new Date();
  const startDateDefault = new Date();
  startDateDefault.setDate(today.getDate() - 30);

  flatpickr("#start-date", {
    dateFormat: "Y-m-d",
    defaultDate: startDateDefault,
    onClose: function (selectedDates) {
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

  let searchData = {
    page: 1,
    size: 10,
    orderBy: 'id',
    orderByDir: 'DESC',
    S: '',
    WH: '',
    SD: document.getElementById('start-date').value,
    ED: document.getElementById('end-date').value
  };

  async function inboundList() {
    const params = new URLSearchParams({
      page: searchData.page,
      size: searchData.size,
      orderBy: searchData.orderBy,
      orderByDir: searchData.orderByDir,
      S: searchData.S,
      WH: searchData.WH,
      SD: searchData.SD,
      ED: searchData.ED
    });

    const response = await fetch(`/api/inbound/list?${params}`);
    const jsonData = await response.json();
    const page = jsonData.pageInfoDTO.page;
    const start = jsonData.pageInfoDTO.start;
    const end = jsonData.pageInfoDTO.end;
    const prev = jsonData.pageInfoDTO.prev;
    const next = jsonData.pageInfoDTO.next;
    const dataList = jsonData.dataList || [];
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

    const pagination = document.getElementById("pagination");
    pagination.innerHTML = '';
    createPagination(pagination, page, start, end, prev, next);
  };

  inboundList(searchData)

  let stautsOption = '';

  document.querySelectorAll('.option').forEach(option => {
    option.addEventListener('click', function () {
      stautsOption = this.getAttribute('data-value');
    })
  })

  document.getElementById('search-btn').addEventListener('click', function () {
    searchData.S = stautsOption;
    searchData.WH = document.getElementById("selected-warehouse-id").value;
    searchData.SD = document.getElementById('start-date').value,
    searchData.ED = document.getElementById('end-date').value

    inboundList(searchData);
  });

  const sizeOptions = document.querySelectorAll('#size-option-list .option');
  sizeOptions.forEach(option => {
    option.addEventListener('click', function() {
      sizeOptions.forEach(opt => opt.classList.remove('selected-option'));
      this.classList.add('selected-option');

      const selectedValue = this.getAttribute('data-value');
      searchData.size = selectedValue;

      inboundList(searchData);
    });
  });

  const sortOptions = document.querySelectorAll('#sort-option-list .option');
  sortOptions.forEach(option => {
    option.addEventListener('click', function() {
      sortOptions.forEach(opt => opt.classList.remove('selected-option'));
      this.classList.add('selected-option');

      const selectedValue = this.getAttribute('data-value');
      searchData.orderByDir = selectedValue;

      inboundList(searchData);
    });
  });

  const pagination = document.getElementById("pagination");
  pagination.addEventListener('click', function (event) {
    if (event.target.classList.contains('page-link')) {
      const selectedPage = event.target.getAttribute('data-page');
      searchData.page = selectedPage;
      inboundList(searchData);
    }
  });
});