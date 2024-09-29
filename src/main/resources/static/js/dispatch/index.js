async function checkDispatchStatus(dispatchId) {
    const response = await fetch(`/api/outbound/dispatch?id=${id}`);
    const jsonData = await response.json();
    const dispatchData = jsonData.data;

    const status = dispatchData.status;

    // 등록 버튼과 수정 버튼을 가져옴
    const registerButton = document.getElementById("registerButton");
    const modifyButton = document.getElementById("modifyButton");

    if (status === 'APPROVED' || status === 'REJECTED') {
        // 'APPROVED' 또는 'REJECTED' 상태일 경우 버튼 비활성화
        registerButton.disabled = true;
        modifyButton.disabled = true;
    } else if (status === 'PENDING') {
        // 'PENDING' 상태일 경우 수정 가능하므로 등록 버튼만 비활성화
        registerButton.disabled = true;
        modifyButton.disabled = false;
    } else {
        // 그 외의 경우 (예: NULL일 경우) 등록 가능하므로 수정 버튼 비활성화
        registerButton.disabled = false;
        modifyButton.disabled = true;
    }
}











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
