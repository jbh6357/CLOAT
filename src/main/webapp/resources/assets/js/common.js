// 전체 적용되는 공통 js 파일입니다!

// 스크롤시 헤더 고정
$(window).on('scroll load', function() {
	if ($(window).scrollTop() > 5) {
		$('.header').addClass('scrl');
	} else {
		$('.header').removeClass('scrl');
	}
});

// 클릭하면 페이지 상단으로 이동
function pageTop() {
	$('html, body').animate({ scrollTop: '0' }, 600);
}	