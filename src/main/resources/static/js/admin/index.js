async function adminList() {
  const page = 1; // 원하는 페이지 번호
  const size = 10; // 원하는 페이지 크기
  const orderBy = 'id'; // 원하는 정렬 기준
  const orderByDir = 'DESC'; // 정렬 방향
  const R = null; // 권한 검색 조건
  const WH = null; // 창고 검색 조건
  const N = null; // 이름 검색 조건

  const response = await fetch(`/api/admin/list?page=${page}&size=${size}&orderBy=${orderBy}&orderByDir=${orderByDir}&R=${R}&WH=${WH}&N=${N}`);

  const jsonData = await response.json()

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