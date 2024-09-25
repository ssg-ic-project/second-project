document.addEventListener('DOMContentLoaded', () => {
<<<<<<< Updated upstream
    // 창고 드롭다운 관련
    const selectWarehouse = document.querySelector('.select-menu:nth-child(1) .select');
    const optionListWarehouse = document.querySelector('.select-menu:nth-child(1) .option-list');
    const optionsWarehouse = optionListWarehouse.querySelectorAll('.option');
    const selectedOptionWarehouse = document.getElementById('selected-option2');


    // 승인 상태 드롭다운 관련
    const selectApproval = document.querySelector('.select-menu:nth-child(2) .select');
    const optionListApproval = document.querySelector('.select-menu:nth-child(2) .option-list');
    const optionsApproval = optionListApproval.querySelectorAll('.option');
    const selectedOptionApproval = document.getElementById('selected-option');



    // 배차 상태 드롭다운 관련
    const selectDispatch = document.querySelector('.select-menu:nth-child(3) .select');
    const optionListDispatch = document.querySelector('.select-menu:nth-child(3) .option-list');
    const optionsDispatch = optionListApproval.querySelectorAll('.option');
    const selectedOptionDispatch = document.getElementById('selected-option3');

=======
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
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
    // 드롭다운 열고 닫기 기능 (배차)
    selectDispatch.addEventListener('click', () => {
        selectDispatch.classList.toggle('active');
        optionListDispatch.classList.toggle('active');
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

=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream

    // 옵션 선택 시 동작 (배차)
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
        if (!selectWarehouse.contains(event.target)) {
            selectWarehouse.classList.remove('active');
            optionListWarehouse.classList.remove('active');
        }

=======
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
>>>>>>> Stashed changes
        if (!selectApproval.contains(event.target)) {
            selectApproval.classList.remove('active');
            optionListApproval.classList.remove('active');
        }

<<<<<<< Updated upstream

        if (!selectDispatch.contains(event.target)) {
            selectDispatch.classList.remove('active');
            optionListDispatch.classList.remove('active');
=======
        if (!selectWarehouse.contains(event.target)) {
            selectWarehouse.classList.remove('active');
            optionListWarehouse.classList.remove('active');
>>>>>>> Stashed changes
        }
    });
});


<<<<<<< Updated upstream
// 달력 추가
const myDateRangePickerCustomRanges = document.getElementById('myDateRangePickerCustomRanges')
if (myDateRangePickerCustomRanges) {
    const optionsCustomRanges = {
        locale: 'en-US',
        ranges: {
            Today: [new Date(), new Date()],
            Yesterday: [
                new Date(new Date().setDate(new Date().getDate() - 1)),
                new Date(new Date().setDate(new Date().getDate() - 1))
            ],
            'Last 7 Days': [
                new Date(new Date().setDate(new Date().getDate() - 6)),
                new Date(new Date())
            ],
            'Last 30 Days': [
                new Date(new Date().setDate(new Date().getDate() - 29)),
                new Date(new Date())
            ],
            'This Month': [
                new Date(new Date().setDate(1)),
                new Date(new Date().getFullYear(), new Date().getMonth() + 1, 0)
            ],
            'Last Month': [
                new Date(new Date().getFullYear(), new Date().getMonth() - 1, 1),
                new Date(new Date().getFullYear(), new Date().getMonth(), 0)
            ]
        }
    }

    new coreui.DateRangePicker(myDateRangePickerCustomRanges, optionsCustomRanges)
}


// Flatpickr 초기화
flatpickr("#start-date", {
    dateFormat: "Y-m-d",
    onClose: function(selectedDates) {
        // 시작일 선택 후, 끝나는 날짜의 최소값 설정
        const startDate = selectedDates[0];
        if (startDate) {
            endPicker.set('minDate', startDate);
        }
    }
});

const endPicker = flatpickr("#end-date", {
    dateFormat: "Y-m-d"
});

// 제출 버튼 클릭 이벤트
document.getElementById('submit').addEventListener('click', function() {
    const startDate = document.getElementById('start-date').value;
    const endDate = document.getElementById('end-date').value;

    if (startDate && endDate) {
        document.getElementById('selected-dates').innerText = `기간: ${startDate}, ~ : ${endDate}`;
    } else {
        alert('모든 날짜를 입력하세요.');
    }
});
=======

// // Select dropdown and option list
// const select = document.querySelector('.select');
// const optionList = document.querySelector('.option-list');
// const options = document.querySelectorAll('.option');
// const selectedOption = document.getElementById('selected-option');
// const selectedOption2 = document.getElementById('selected-option2');
//
//
// // Toggle dropdown on click
// select.addEventListener('click', () => {
//     select.classList.toggle('active');
// });
//
// // Handle option click
// options.forEach(option => {
//     option.addEventListener('click', () => {
//         options.forEach(opt => opt.classList.remove('selected')); // Remove selected class from all options
//         option.classList.add('selected'); // Add selected class to clicked option
//         selectedOption.textContent = option.textContent; // Update selected option text
//         select.classList.remove('active'); // Close the dropdown
//     });
// });
//
//
// // Close dropdown if clicked outside
// document.addEventListener('click', (event) => {
//     if (!select.contains(event.target)) {
//         select.classList.remove('active');
//     }
// });
//
//
//
// // // 창고 드롭다운 관련 선택 및 이벤트 처리
// // const selectWarehouse = document.querySelector('.select');
// // const optionListWarehouse = document.querySelector('.option-list');
// // const optionsWarehouse = document.querySelectorAll('.option');
// // const selectedOptionWarehouse = document.getElementById('selected-option2');
// //
// // // 드롭다운 클릭 시 열고 닫기
// // selectWarehouse.addEventListener('click', () => {
// //     selectWarehouse.classList.toggle('active');
// // });
// //
// // // 옵션 선택 시 동작
// // optionsWarehouse.forEach(option => {
// //     option.addEventListener('click', () => {
// //         optionsWarehouse.forEach(opt => opt.classList.remove('selected'));  // 모든 옵션에서 'selected' 클래스 제거
// //         option.classList.add('selected');  // 클릭된 옵션에 'selected' 클래스 추가
// //         selectedOptionWarehouse.textContent = option.textContent;  // 선택된 값 표시
// //         selectWarehouse.classList.remove('active');  // 드롭다운 닫기
// //     });
// // });
// //
// // // 드롭다운 외부 클릭 시 닫기
// // document.addEventListener('click', (event) => {
// //     if (!selectWarehouse.contains(event.target)) {
// //         selectWarehouse.classList.remove('active');
// //     }
// // });
// //
// //
// //
>>>>>>> Stashed changes
