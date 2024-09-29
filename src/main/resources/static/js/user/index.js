async function userList() {
  const page = 1; // 원하는 페이지 번호
  const size = 10; // 원하는 페이지 크기
  const orderBy = 'id'; // 원하는 정렬 기준
  const orderByDir = 'DESC'; // 정렬 방향
  const S = null; // 승인 상태 검색 조건
  const N = null; // 상호명 검색 조건
  const E = null; // 이메일 검색 조건

  const response = await fetch(`/api/user/list?page=${page}&size=${size}&orderBy=${orderBy}&orderByDir=${orderByDir}&S=${S}&N=${N}&E=${E}`);

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