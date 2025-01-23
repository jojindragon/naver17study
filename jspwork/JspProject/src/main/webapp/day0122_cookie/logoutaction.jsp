<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/* 현재 브라우저에 저장된 모든 쿠키 값 얻기, 없을 경우 null  */
	Cookie[] cookies = request.getCookies();
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			String name = cookies[i].getName();
			if(name.equals("loginok")) {
				Cookie loginCookie = cookies[i];
				
				loginCookie.setPath("/");
				// 쿠키 유지시간을 0으로 만들고 다시 브라우저에 저장
				// loginok 쿠키는 바로 소멸
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				break;
			}
		}
	}
	// 메인 페이지로 이동
	response.sendRedirect("./cookiemain.jsp");
%>