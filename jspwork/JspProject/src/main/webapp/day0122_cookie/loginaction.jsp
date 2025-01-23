<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String amho = request.getParameter("amho");

	/* 암호가 bitcamp502가 맞으면 쿠키 생성(이름: loginok) */
	if(amho.equals("bitcamp502")) {
		// name: loginok, value: 아무거나 저장(이번에는 의미 X)
		Cookie cookie = new Cookie("loginok", amho);
		
		cookie.setPath("/"); // 저장 위치
		cookie.setMaxAge(60*60*24); // 쿠키 유지 시간, 초 단위 - 24시간
		
		response.addCookie(cookie); // 브라우저에 쿠키 추가
		response.sendRedirect("./cookiemain.jsp"); // 메인페이지 이동
	} else {%>
		<script>
			alert("맞지 않는 암호!");
			history.back();
		</script>
	<%}
%>