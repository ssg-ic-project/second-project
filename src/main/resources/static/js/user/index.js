import {createPagination} from '/js/common/pagination.js';

document.addEventListener('DOMContentLoaded', function () {
  let searchData = {
    page: 1,
    size: 10,
    orderBy: 'id',
    orderByDir: 'DESC',
    S: '',
    N: '',
    E: ''
  };

  async function userList() {
    const params = new URLSearchParams({
      page: searchData.page,
      size: searchData.size,
      orderBy: searchData.orderBy,
      orderByDir: searchData.orderByDir,
      S: searchData.S,
      N: searchData.N,
      E: searchData.E,
    });

    const response = await fetch(`/api/user/list?${params}`);
    const jsonData = await response.json();
    const page = jsonData.pageInfoDTO.page;
    const start = jsonData.pageInfoDTO.start;
    const end = jsonData.pageInfoDTO.end;
    const prev = jsonData.pageInfoDTO.prev;
    const next = jsonData.pageInfoDTO.next;
    const dataList = jsonData.dataList || [];
    const tbody = document.querySelector("#user-list tbody");

    tbody.innerHTML = '';

    dataList.forEach(user => {
      const row = document.createElement('tr');
      row.innerHTML = `
      <td><a href="/user?id=${user.id}">${user.id ? user.id : '-'}</a></td>
      <td>${user.name ? user.name : '-'}</td>
      <td>${user.companyName ? user.companyName : '-'}</td>
      <td>${user.email ? user.email : '-'}</td>
      <td>${user.businessNumber ? user.businessNumber : '-'}</td>
      <td>${user.phone ? user.phone : '-'}</td>
      <td>${user.status ? user.status : '-'}</td>
    `;
      tbody.appendChild(row);
    });

    const pagination = document.getElementById("pagination");
    pagination.innerHTML = '';
    createPagination(pagination, page, start, end, prev, next);
  }

  userList(searchData);

  let statusOption = '';

  document.querySelectorAll('.option').forEach(option => {
    option.addEventListener('click', function () {
      statusOption = this.getAttribute('data-value');
    })
  })

  document.getElementById('search-btn').addEventListener('click', function () {
    searchData.N = document.getElementById("companyName").value;
    searchData.E = document.getElementById('email').value
    searchData.S = statusOption;

    userList(searchData);
  });

  const sizeOptions = document.querySelectorAll('#size-option-list .option');
  sizeOptions.forEach(option => {
    option.addEventListener('click', function() {
      sizeOptions.forEach(opt => opt.classList.remove('selected-option'));
      this.classList.add('selected-option');

      const selectedValue = this.getAttribute('data-value');
      searchData.size = selectedValue;

      userList(searchData);
    });
  });

  const sortOptions = document.querySelectorAll('#sort-option-list .option');
  sortOptions.forEach(option => {
    option.addEventListener('click', function() {
      sortOptions.forEach(opt => opt.classList.remove('selected-option'));
      this.classList.add('selected-option');

      const selectedValue = this.getAttribute('data-value');
      searchData.orderByDir = selectedValue;

      userList(searchData);
    });
  });

  const pagination = document.getElementById("pagination");
  pagination.addEventListener('click', function (event) {
    if (event.target.classList.contains('page-link')) {
      const selectedPage = event.target.getAttribute('data-page');
      searchData.page = selectedPage;
      userList(searchData);
    }
  });
});