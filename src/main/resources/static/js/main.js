//$(document).ready(function () {
//	
//	
//    const slides = document.querySelector('.swiper_exhb'); //전체 슬라이드 컨테이너
//    const slideImg = document.querySelectorAll('.exhb_slide_info_area .swiper-slide'); //모든 슬라이드들
//    let currentIdx = 0; //현재 슬라이드 index
//    const slideCount = slideImg.length; // 슬라이드 개수
//    const prev = document.querySelector('.exhb_navigation_prev'); //이전 버튼
//    const next = document.querySelector('.exhb_navigation_next'); //다음 버튼
//    const slideWidth = 1200; //한개의 슬라이드 넓이
//    const slideMargin = 0; //슬라이드간의 margin 값
//    makeClone(); // 처음이미지와 마지막 이미지 복사 함수
//    initfunction(); //슬라이드 넓이와 위치값 초기화 함수
//    function makeClone() {
//        let cloneSlide_first = slideImg[0].cloneNode(true);
//        let cloneSlide_last = slides.lastElementChild.cloneNode(true);
//        slides.append(cloneSlide_first);
//        slides.insertBefore(cloneSlide_last, slides.firstElementChild);
//    }
//
//    function initfunction() {
//        slides.style.width = (slideWidth + slideMargin) * (slideCount + 2) + 'px';
//        slides.style.left = -(slideWidth + slideMargin) + 'px';
//    }
//
//    next.addEventListener('click', function () {
//        //다음 버튼 눌렀을때
//        if (currentIdx <= slideCount - 1) {
//            //슬라이드이동
//            slides.style.left = -(currentIdx + 2) * (slideWidth + slideMargin) + 'px';
//            slides.style.transition = `${0.5}s ease-out`; //이동 속도
//        }
//        if (currentIdx === slideCount - 1) {
//            //마지막 슬라이드 일때
//            setTimeout(function () {
//                //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
//                slides.style.left = -(slideWidth + slideMargin) + 'px';
//                slides.style.transition = `${0}s ease-out`;
//            }, 500);
//            currentIdx = -1;
//        }
//        currentIdx += 1;
//    });
//    prev.addEventListener('click', function () {
//        //이전 버튼 눌렀을때
//        console.log(currentIdx);
//        if (currentIdx >= 0) {
//            slides.style.left = -currentIdx * (slideWidth + slideMargin) + 'px';
//            slides.style.transition = `${0.5}s ease-out`;
//        }
//        if (currentIdx === 0) {
//            setTimeout(function () {
//                slides.style.left = -slideCount * (slideWidth + slideMargin) + 'px';
//                slides.style.transition = `${0}s ease-out`;
//            }, 500);
//            currentIdx = slideCount;
//        }
//        currentIdx -= 1;
//    });
//});
