<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
session.removeAttribute("loginok");

// 메인페이지 이동
response.sendRedirect("./sessionmain.jsp");

%>