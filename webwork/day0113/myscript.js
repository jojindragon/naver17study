window.onload = function() {
    let mycar = document.querySelectorAll(".mycar");

    /* 0번 이미지 이벤트
        마우스: 올리면 ../photo/K-052.png 변경, 벗어나면 원상복구
     */
    let photo = mycar[0].getAttribute("src");
    mycar[0].onmouseover = function() {
        this.setAttribute("src", "../photo/K-052.png");
    };
    mycar[0].onmouseout = function() {
        this.setAttribute("src", photo);
    };


    /* 1번 이미지 이벤트
        마우스: 올리면 border 설정, 벗어나면 원상복구
     */
    mycar[1].onmouseover = function() {
        this.style.border = "inset 5px lightgreen";
    };
    mycar[1].onmouseout = function() {
        this.style.border = "none";
    };


    /* 2번 이미지 이벤트
        마우스: 올리면 .happy 적용, 벗어나면 원상복구
        .happy 미리 만들기
     */
    mycar[2].onmouseover = function() {
        this.setAttribute("class", "mycar happy");
    };
    mycar[2].onmouseout = function() {
        this.setAttribute("class", "mycar");
    };
};