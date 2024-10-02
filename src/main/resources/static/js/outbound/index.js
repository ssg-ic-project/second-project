document.addEventListener('DOMContentLoaded', () => {
    // 창고 드롭다운 관련
    // const selectWarehouse = document.querySelector(".select-menu");
    // const optionListWarehouse = document.querySelector(".option-list");
    const selectWarehouse = document.querySelector('.warehouse-filter .select-menu .select');
    const optionListWarehouse = document.querySelector('.warehouse-filter .select-menu .option-list');
    const optionsWarehouse = optionListWarehouse.querySelectorAll('.option');
    const selectedOptionWarehouse = document.getElementById('selected-option2');


    // 승인 상태 드롭다운 관련
    const selectApproval = document.querySelector('.approval .select-menu .select');
    const optionListApproval = document.querySelector('.approval .select-menu .option-list');
    const optionsApproval = optionListApproval.querySelectorAll('.option');
    const selectedOptionApproval = document.getElementById('selected-option');

    // // 배차 상태 드롭다운 관련
    // const selectDispatch = document.querySelector('.select-menu:nth-child(3) .select');
    // const optionListDispatch = document.querySelector('.select-menu:nth-child(3) .option-list');
    // const optionsDispatch = optionListApproval.querySelectorAll('.option');
    // const selectedOptionDispatch = document.getElementById('selected-option3');

    // 배차 상태 드롭다운 관련
    const selectDispatch = document.querySelector('.select-menu .select3');
    const optionListDispatch = document.querySelector('.select-menu .option-list3');
    const optionsDispatch = optionListApproval.querySelectorAll('.option');
    const selectedOptionDispatch = document.getElementById('selected-option3');


    // 드롭다운 열고 닫기 기능 (창고)
    selectWarehouse.addEventListener('click', () => {
        selectWarehouse.classList.toggle('active');
        optionListWarehouse.classList.toggle('active');
    });


    // 드롭다운 열고 닫기 기능 (승인 상태)
    selectApproval.addEventListener('click', () => {
        selectApproval.classList.toggle('active');
        optionListApproval.classList.toggle('active');
    });


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
        if (!selectApproval.contains(event.target)) {
            selectApproval.classList.remove('active');
            optionListApproval.classList.remove('active');
        }
        if (!selectDispatch.contains(event.target)) {
            selectDispatch.classList.remove('active');
            optionListDispatch.classList.remove('active');
        }
    });

    // 지은님 코드
    const today = new Date();
    const startDateDefault = new Date();
    startDateDefault.setDate(today.getDate() - 30);

    flatpickr("#start-date", {
        dateFormat: "Y-m-d",
        defaultDate: startDateDefault,
        onClose: function (selectedDates) {
            const startDate = selectedDates[0];
            if (startDate) {
                endPicker.set('minDate', startDate);
            }
        }
    });

    const endPicker = flatpickr("#end-date", {
        dateFormat: "Y-m-d",
        defaultDate: today,
        minDate: startDateDefault
    });

    document.getElementById('start-date').value = startDateDefault.toISOString().split('T')[0];
    document.getElementById('end-date').value = today.toISOString().split('T')[0];

    let searchData = {
        page: 1,
        size: 10,
        orderBy: 'id',
        orderByDir: 'DESC',
        S: '',
        WH: '',
        SD: document.getElementById('start-date').value,
        ED: document.getElementById('end-date').value
    };
    async function outboundList(){
        const params = new URLSearchParams({
            page: searchData.page,
            size: searchData.size,
            orderBy: searchData.orderBy,
            orderByDir: searchData.orderByDir,
            S: searchData.S,
            WH: searchData.WH,
            SD: searchData.SD,
            ED: searchData.ED,
            DS: searchData.DS,
            OS: searchData.OS
        })
        const response = await fetch(`/api/outbound/list?${params}`);
        const jsonData = await response.json();
        const dataList = jsonData.dataList || [];
        const tbody = document.querySelector("#outbound-list tbody");

        tbody.innerHTML = '';

        dataList.forEach(outbound => {
            const row = document.createElement('tr');
            row.innerHTML = `
      <td><a href="/outbound?id=${outbound.id}">${outbound.id ? outbound.id : '-'}</a></td>
      <td>${outbound.productName ? outbound.productName : '-'}</td>
      <td>${outbound.quantity ? outbound.quantity : '-'}</td>
      <td>${outbound.companyName ? outbound.companyName : '-'}</td>
      <td><a href="/outbound/dispatch?id=${dispatch.id}">${outbound.isDispatch ? outbound.isDispatch : '-'}</a>></td>
      <td>${outbound.isInvoice ? outbound.isInvoice : '-'}</td>
      <td>${outbound.status ? outbound.status : '-'}</td>
    `;
            tbody.appendChild(row);
        });
    }
    outboundList(searchData)

    let startOption = '';

    document.querySelectorAll('.option').forEach(option => {
        option.addEventListener('click', function () {
            startOption = this.getAttribute('data-value');
        })
    })

    document.getElementById('search-btn').addEventListener('click', function () {
        searchData.S = startOption;
        searchData.WH = document.getElementById("selected-warehouse-id").value;
        searchData.SD = document.getElementById('start-date').value,
            searchData.ED = document.getElementById('end-date').value

        outboundList(searchData);
    });

});


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



// const fetchOutboundData = (id, status) => {
//     axios.get(`/api/outbound`, {
//         params: {
//             id: id,
//             status: status
//         }
//     })
//         .then(response => {
//             console.log(response.data);
//         })
//         .catch(error => {
//             console.error("There was an error!", error);
//         });
// };
//
// // Example: 상태에 따른 버튼 클릭
// document.getElementById("approvedBtn").addEventListener("click", () => {
//     fetchOutboundData(1, 'APPROVED');
// });
// document.getElementById("pendingBtn").addEventListener("click", () => {
//     fetchOutboundData(1, 'PENDING');
// });
// document.getElementById("rejectedBtn").addEventListener("click", () => {
//     fetchOutboundData(1, 'REJECTED');
// });
