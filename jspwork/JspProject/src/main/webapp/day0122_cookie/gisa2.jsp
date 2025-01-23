<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
<link
	href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body * {
	font-family: 'Jua';
}
</style>
</head>
<%
	boolean blogin = false;

	/* 현재 브라우저에 저장된 모든 쿠키 값 얻기, 없을 경우 null  */
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			// loginok 라는 쿠기 여부 검사
			if(cookies[i].getName().equals("loginok")) {
				blogin = true;
				break;
			}
		}
	}
%>
<body>
<%
	if(blogin) {
		// 로그인 한 상태
	%>
	<pre>
	[스포티비뉴스=김태우 기자] 하주석(31·한화)은 오랜 기간 한화의 주전 유격수로 기대를 모았고, 또 그렇게 활약을 했던 선수다. 
	입단 당시의 어마어마한 기대치를 다 채우지는 못했어도 적어도 한 팀의 주전 유격수로 눈높이를 낮추면 그럭저럭 기준에 부합하는 수치였다.

	연봉에서도 이를 알 수 있다. 
	하주석은 2018년 첫 억대 연봉(1억2000만 원)에 진입한 뒤 이후 2023년까지 6년 연속 억대 연봉자의 타이틀을 지켰다. 
	2022년에는 2억 원대 진입에 성공하기도 했다. 
	하지만 2023년부터 이 구도에 균열이 생기기 시작했다. 
	그리고 2025년이 시작된 지금, 예전에는 쉽게 상상하기 어려웠던 일이 벌어지고 있다.
	</pre>
	<%} else {
		// 로그인 안 한 상태
	%>
		<script type="text/javascript">
			alert("먼저 로그인을 해라!");
			history.back(); // 이전 페이지로 이동
		</script>
	<%}
%>

</body>
</html>