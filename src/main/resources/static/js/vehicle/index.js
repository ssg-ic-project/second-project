document.addEventListener('DOMContentLoaded', () => {
    // 승인 상태 드롭다운 관련
    const selectVehicle = document.querySelector('.select-menu1 .select');
    const optionListVehicle = document.querySelector('.select-menu1 .option-list');
    const optionsVehicle = optionListVehicle.querySelectorAll('.option');
    const selectedOptionVehicle = document.getElementById('selected-option');

    // 창고 드롭다운 관련
    const selectDispatch = document.querySelector('.select-menu2 .select2');
    const optionListDispatch = document.querySelector('.select-menu2 .option-list');
    const optionsDispatch = optionListDispatch.querySelectorAll('.option');
    const selectedOptionDispatch = document.getElementById('selected-option2');

    // 드롭다운 열고 닫기 기능 (승인 상태)
    selectVehicle.addEventListener('click', () => {
        selectVehicle.classList.toggle('active');
        optionListVehicle.classList.toggle('active');
    });

    // 드롭다운 열고 닫기 기능 (창고)
    selectDispatch.addEventListener('click', () => {
        selectDispatch.classList.toggle('active');
        optionListDispatch.classList.toggle('active');
    });

    // 옵션 선택 시 동작 (승인 상태)
    optionsVehicle.forEach(option => {
        option.addEventListener('click', () => {
            optionsVehicle.forEach(opt => opt.classList.remove('selected'));
            option.classList.add('selected');
            selectedOptionVehicle.textContent = option.textContent;
            selectVehicle.classList.remove('active');
            optionListVehicle.classList.remove('active');
        });
    });

    // 옵션 선택 시 동작 (창고)
    optionsDispatch.forEach(option => {
        option.addEventListener('click', () => {
            optionsDispatch.forEach(opt => opt.classList.remove('selected'));
            option.classList.add('selected');
            selectedOptionDispatch.textContent = option.textContent;
            selectDispatch.classList.remove('active');
            optionListDispatch.classList.remove('active');
        });
    });

    // 드롭다운 외부 클릭 시 닫기
    document.addEventListener('click', (event) => {
        if (!selectVehicle.contains(event.target)) {
            selectVehicle.classList.remove('active');
            optionListVehicle.classList.remove('active');
        }

        if (!selectDispatch.contains(event.target)) {
            selectDispatch.classList.remove('active');
            optionListDispatch.classList.remove('active');
        }
    });
});

