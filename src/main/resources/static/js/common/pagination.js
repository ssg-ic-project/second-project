function createPaginationBtn(text, page, isDisabled) {
  const li = document.createElement('li');
  li.classList.add('page-item');

  const button = document.createElement('button');
  button.classList.add('page-link');

  if (isDisabled) {
    button.disabled = true;
  } else {
    button.setAttribute('data-page', page);
  }

  button.innerText = text;

  li.appendChild(button);
  return li;
}

function createPagination(pagination, page, start, end, prev, next) {
  if (prev) {
    // 이전 페이지 존재 O
    pagination.appendChild(createPaginationBtn('<', page - 1, false));
  } else {
    // 이전 페이지 존재 X
    pagination.appendChild(createPaginationBtn('<', null, true));
  }

  for (let i = start; i <= end; i++) {
    pagination.appendChild(createPaginationBtn(i, i, false));
  }

  if (next) {
    // 다음 페이지 존재 O
    pagination.appendChild(createPaginationBtn('>', page + 1, false));
  } else {
    // 다음 페이지 존재 X
    pagination.appendChild(createPaginationBtn('>', null, true));
  }
}

export { createPagination };