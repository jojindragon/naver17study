$(function() {
    /* 
        총 클릭 - 0~11 사이의 난수 발생
        -> 발생한 난수의 해당하는 인형을 소멸        
        이미 사라진 경우 - 메시지
     */
    $(".gun").click(function() {
        let idx = parseInt(Math.random() * 12);

        if($(".sunban img").eq(idx).is(":hidden")) {
            $("#msg").html("꽝!!! "+(idx+1)+"번째 인형은 이미 없다.");
        } else {
            $("#msg").html((idx+1)+"번째 인형 명중!");
            // $(".sunban img").eq(idx).fadeOut('fast');
            $(".sunban img").eq(idx).hide();
        }

        // 게임 종료: hidden 갯수 == 12
        let n = $(".sunban img:hidden").length;
        if(n==12) {
            $("#msg").html("Game Over!!!")
        }
    });

    // 돈 클릭 시 돈은 사라지고 나머지 모두 초기화
    $(".money img").click(function() {
        $(".sunban img").show();
        $("#msg").html("");

        // $(this).css("visibility", "hidden"); // 자리차지
        $(this).css("display", "none"); // 자리 미차지
    });

});