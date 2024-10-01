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
});