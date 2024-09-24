document.addEventListener('DOMContentLoaded', () => {

    const selectApproval = document.querySelector('.select'); // 수정
    const optionListApproval = document.querySelector('.option-list'); // 수정


    const optionsApproval = optionListApproval.querySelectorAll('.option');
    const selectedOptionApproval = document.getElementById('selected-option');

    // 드롭다운 열고 닫기 기능 (승인 상태)
    selectApproval.addEventListener('click', () => {
        selectApproval.classList.toggle('active');
        optionListApproval.classList.toggle('active');
    });

    // 옵션 선택 시 동작 (승인 상태)
    optionsApproval.forEach(option => {
        option.addEventListener('click', () => {
            optionsApproval.forEach(opt => opt.classList.remove('selected'));
            option.classList.add('selected');
            selectedOptionApproval.textContent = option.textContent;
            selectApproval.classList.remove('active');
            optionListApproval.classList.remove('active');
        });
    });

    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener('click', (event) => {
        if (!selectApproval.contains(event.target)) {
            selectApproval.classList.remove('active');
            optionListApproval.classList.remove('active');
        }

    });
});
