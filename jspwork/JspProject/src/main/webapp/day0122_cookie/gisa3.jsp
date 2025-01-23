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
	(엑스포츠뉴스 서울중앙지법, 조혜진 기자) 가수 이승환이 100여 명 공연 예매자들과 함께 손해배상소송을 진행한다.

	이승환 측 법률대리인 법무법인 해마루 임재성 변호사 22일 오전 서울중앙지방법원 동관 1번 출입구 앞에서 
	구미시장 김장호의 이승환 콘서트 대관취소에 대한 손해배상소송 소장 접수 언론 브리핑을 진행했다.
	
	앞서 이승환은 자신의 35주년 콘서트 'HEAVEN'의 공연이 예정돼 있던 구미시문화예술회관의 사용허가를 부당하게 취소당했다며 이에 대한 소장을 접수할 것이라고 알린 바.
	이날 임재성 변호사는 원고 이승환 외 101명, 피고 구미시장 김장호 외 1명으로, 온라인으로 소장을 접수해 사건번호를 부여받았다고 밝혔다.
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