
// document.addEventListener("DOMContentLoaded", () => {
    // "출고 지시서 출력" 버튼을 선택합니다.
    // const printButton = document.getElementById("print-btn");
    //
    // // 모달을 여는 이벤트 리스너 추가
    // printButton.addEventListener("click", () => {
    //     const printModal = new bootstrap.Modal(document.getElementById("printModal"));
    //     printModal.show();
    // });

// function handleOutboundClick(id) {
//     getOutboundDetails(id);
// }

// Get detailed data for each outbound request asynchronously
async function getOutboundDetails(id) {

    const response = await fetch(`/api/outbound?id=${id}`);
    const jsonData = await response.json();
    const data = jsonData.data;

//     try {
//         const response = await fetch(`/api/outbound/detail?id=${outboundId}`);
//         console.log(response.data); // For testing purposes
//         displayOutboundDetails(response.data);
//         await getOutboundApprovalHistory(id);
//     } catch (error) {
//         console.error("Error fetching outbound details", error);
//         alert("Failed to load outbound details. Please try again.");
//     }
// }
// getOutboundDetails(outboundId)
// function displayOutboundDetails(data) {
    // Update the page with outbound details
    document.getElementById("id").innerText = data.id;
    document.getElementById("expectedDate").innerText = data.expectedDate || 'N/A'; // Handle missing data
    document.getElementById("quantity").innerText = data.quantity || 'N/A';
    document.getElementById("createdAt").innerText = data.createdAt || 'N/A';
    document.getElementById("updatedAt").innerText = data.updatedAt || 'N/A';
    document.getElementById("remarks").innerText = data.remarks || 'No remarks'; // Display 'No remarks' if undefined
    document.getElementById("warehouseId").innerText = data.warehouseId || 'N/A';
    document.getElementById("sectionCellId").innerText = `Section ${data.sectionId || 'N/A'}, Cell ${data.cellId || 'N/A'}`;
    document.getElementById("warehouseName").innerText = data.warehouseName || 'N/A';
    document.getElementById("stockQuantity").innerText = data.stockQuantity || 'N/A';
    // document.getElementById("inboundExpectedDate").innerText = data.inboundExpectedDate || 'N/A';
    document.getElementById("productId").innerText = data.productId || 'N/A';
    document.getElementById("productVolume").innerText = `Height: ${data.productHeight || 'N/A'} * Width: ${data.productWidth || 'N/A'} * Depth: ${data.productDepth || 'N/A'}`;
    document.getElementById("productName").innerText = data.productName || 'N/A';
    document.getElementById("categoryId").innerText = data.productCategoryId || 'N/A';
    document.getElementById("userId").innerText = data.userId || 'N/A';
    document.getElementById("userName").innerText = data.userName || 'N/A';
    document.getElementById("companyName").innerText = data.companyName || 'N/A';
    document.getElementById("userEmail").innerText = data.userEmail || 'N/A';
    document.getElementById("userPhone").innerText = data.userPhone || 'N/A';
// }
//userName 추가하기

// On page load
// window.onload = function() {
//     const outboundId = /*[[${id}]]*/ '';  // Get the outbound ID from server-side rendered template
//     if (outboundId) {
//         getOutboundDetails(outboundId);
//     } else {
//         console.error("Outbound ID not available");
//     }
// };
    function getOutboundApprovalHistory(id) {
        fetch(`/api/outbound?id=${id}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json(); // Parse JSON from the response
            })
            .then(data => {
                console.log(data); // For testing purposes
                displayApprovalHistory(data);
            })
            .catch(error => {
                console.error("Error fetching approval history", error);
            });
    }

    function displayApprovalHistory(data) {
        const approvalTableBody = document.getElementById("approval-history-table-body");
        approvalTableBody.innerHTML = ''; // Clear any previous data

        data.forEach(approval => {
            const row = document.createElement("tr");

            const statusCell = document.createElement("td");
            statusCell.innerText = approval.status;

            const reasonCell = document.createElement("td");
            reasonCell.innerText = approval.rejectionReason || '-';

            const dateCell = document.createElement("td");
            dateCell.innerText = approval.createdAt;

            row.appendChild(statusCell);
            row.appendChild(reasonCell);
            row.appendChild(dateCell);
            approvalTableBody.appendChild(row);
        });
    }


//출고 상세에 나오는 승인 내역 테이블 보여주기.
//     async function getOutboundApprovalHistory(id) {
//         try {
//             const response = await fetch(`/api/outbound?id=${id}`);
//             console.log(response.data); // For testing purposes
//             displayApprovalHistory(response.data);
//         } catch (error) {
//             console.error("Error fetching approval history", error);
//         }
//     }

//     function displayApprovalHistory(data) {
//         const approvalTableBody = document.getElementById("approval-history-table-body");
//         approvalTableBody.innerHTML = ''; // Clear any previous data
//
//         data.forEach(approval => {
//             const row = document.createElement("tr");
//
//             const statusCell = document.createElement("td");
//             statusCell.innerText = approval.status;
//
//             const reasonCell = document.createElement("td");
//             reasonCell.innerText = approval.rejectionReason || '-';
//
//             const dateCell = document.createElement("td");
//             dateCell.innerText = approval.createdAt;
//
//             row.appendChild(statusCell);
//             row.appendChild(reasonCell);
//             row.appendChild(dateCell);
//             approvalTableBody.appendChild(row);
//         });
//     };
}






// You can call this function after page load or on user interaction
// window.onload = function() {
//     const outboundId = /*[[${id}]]*/ '';  // Get the outbound ID from server-side rendered template
//     getOutboundApprovalHistory(outboundId);
// };

// });