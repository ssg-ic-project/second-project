const navDiv = document.querySelector(".search-span");
console.log(navDiv);
const minWidth = 768; // 최소 너비 설정

function checkWidth() {
    if (window.innerWidth < minWidth) {
        navDiv.style.display = 'none';
    } else {
        navDiv.style.display = 'block';
    }
}

// 초기 체크
checkWidth();

// 리사이즈 이벤트 리스너 추가
window.addEventListener('resize', checkWidth);