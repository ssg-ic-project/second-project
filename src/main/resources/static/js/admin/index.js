document.addEventListener('DOMContentLoaded', function () {
  let searchData = {
    page: 1,            // 원하는 페이지 번호
    size: 10,           // 원하는 페이지 크기
    orderBy: 'id',      // 원하는 정렬 기준
    orderByDir: 'DESC', // 정렬 방향
    R: '',            // 권한 검색 조건
    WH: '',           // 창고 검색 조건
    N: ''             // 이름 검색 조건
  }

  async function adminList(searchData) {
    const params = new URLSearchParams({
      page: searchData.page,
      size: searchData.size,
      orderBy: searchData.orderBy,
      orderByDir: searchData.orderByDir,
      R: searchData.R,
      WH: searchData.WH,
      N: searchData.N,
    })

    console.log('params: ' + params)
    const response = await fetch(
        `/api/admin/list?${params}`);

    const jsonData = await response.json();

    const dataList = jsonData.dataList || [];

    const tbody = document.querySelector("#admin-list tbody");

    tbody.innerHTML = '';

    dataList.forEach(admin => {
      const row = document.createElement('tr');
      row.innerHTML = `
      <td><a href="/admin?id=${admin.id}">${admin.id ? admin.id : '-'}</a></td>
      <td>${admin.name ? admin.name : '-'}</td>
      <td>${admin.companyEmail ? admin.companyEmail : '-'}</td>
      <td>${admin.warehouseName ? admin.warehouseName : '-'}</td>
      <td>${admin.role ? admin.role : '-'}</td>
      <td>${admin.phone ? admin.phone : '-'}</td>
      <td>${admin.createdAt ? admin.createdAt : '-'}</td>
    `;
      tbody.appendChild(row);
    });
  }

  adminList(searchData);

  let roleOption = '';

  document.querySelectorAll('.option').forEach(option => {
    option.addEventListener('click', function () {
      roleOption = this.getAttribute('data-value');
    })
  })

  document.getElementById('search-btn').addEventListener('click', function () {
    searchData.R = roleOption;
    searchData.WH = document.getElementById('w').value;
    searchData.N = document.getElementById('name').value;
    console.log('조건 검색\n' + JSON.stringify(searchData))

    adminList(searchData);
  });
});