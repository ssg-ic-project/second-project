document.addEventListener("DOMContentLoaded", () => {
    // "출고 지시서 출력" 버튼을 선택합니다.
    const printButton = document.querySelector(".print-btn");

    // 모달을 여는 이벤트 리스너 추가
    printButton.addEventListener("click", () => {
        const printModal = new bootstrap.Modal(document.getElementById("printModal"));
        printModal.show();
    });
});