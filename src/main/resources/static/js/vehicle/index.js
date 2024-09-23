document.addEventListener('DOMContentLoaded', () => {
    // 승인 상태 드롭다운 관련
    const selectApproval = document.querySelector('.select-menu:nth-child(1) .select');
    const optionListApproval = document.querySelector('.select-menu:nth-child(1) .option-list');
    const optionsApproval = optionListApproval.querySelectorAll('.option');
    const selectedOptionApproval = document.getElementById('selected-option');

    // 창고 드롭다운 관련
    const selectWarehouse = document.querySelector('.select-menu:nth-child(2) .select');
    const optionListWarehouse = document.querySelector('.select-menu:nth-child(2) .option-list');
    const optionsWarehouse = optionListWarehouse.querySelectorAll('.option');
    const selectedOptionWarehouse = document.getElementById('selected-option2');

    // 드롭다운 열고 닫기 기능 (승인 상태)
    selectApproval.addEventListener('click', () => {
        selectApproval.classList.toggle('active');
        optionListApproval.classList.toggle('active');
    });

    // 드롭다운 열고 닫기 기능 (창고)
    selectWarehouse.addEventListener('click', () => {
        selectWarehouse.classList.toggle('active');
        optionListWarehouse.classList.toggle('active');
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

    // 옵션 선택 시 동작 (창고)
    optionsWarehouse.forEach(option => {
        option.addEventListener('click', () => {
            optionsWarehouse.forEach(opt => opt.classList.remove('selected'));
            option.classList.add('selected');
            selectedOptionWarehouse.textContent = option.textContent;
            selectWarehouse.classList.remove('active');
            optionListWarehouse.classList.remove('active');
        });
    });

    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener('click', (event) => {
        if (!selectApproval.contains(event.target)) {
            selectApproval.classList.remove('active');
            optionListApproval.classList.remove('active');
        }

        if (!selectWarehouse.contains(event.target)) {
            selectWarehouse.classList.remove('active');
            optionListWarehouse.classList.remove('active');
        }
    });
});

