$(function() {
    // h1.title을 클릭 - .music-list를 slideDown 효과
    $("h1.title").click(function() {
        $("ul.music-list").slideDown('slow');
    });

    // 노래제목 클릭 이벤트
    $("ul.music-list li").click(function() {
        // 노래제목 얻기
        let title = $(this).text();

        // h1.title에 넣기
        $("h1.title").text(title);

        // 클릭한 곳 class 얻기
        let selClass = $(this).attr("class");

        // cd effect 효과
        $("#cd").animate({width: '0'}, 'slow', function() {
            // cd 변경
            $(this).attr("class", selClass);

            // 너비를 다시 300으로
            $(this).animate({width: '300px'}, 'slow');
        });

        // 마지막에 노래목록 slideUp
        $("ul.music-list").slideUp('slow');
    });
});
