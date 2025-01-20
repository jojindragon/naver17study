$(function() {
    // 벽지 이미지 클릭 시 이벤트
    $("ul.list img").click(function() {
        // 부모 태그인 li에 active class 추가
        $(this).parent().addClass("active");

        // 부모(li)의 형제들에 추가된 active를 제거
        $(this).parent().siblings().removeClass("active");

        // 클릭한 이미지의 title 열기
        let title = $(this).attr("title");
        // title을 h1.title에 넣기
        $("h1.title").text(title);

        // 이미지 src 얻기
        let img = $(this).attr("src");
        // 이미지 src를 .wall에 백그라운드 형태로 넣기
        let url = `url(${img})`;
        $(".wall").css("background-image", url);
    });
});