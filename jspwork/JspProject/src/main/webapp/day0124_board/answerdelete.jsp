<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="adao" class="simpleboard.data.SimpleAnswerDao" />
<jsp:useBean id="adto" class="simpleboard.data.SimpleAnswerDto" />
<jsp:setProperty property="*" name="adto"/>

<%
	//삭제 실행
	adao.deleteAnswer(adto.getIdx());
	//삭제 후 본래 페이지 이동
	response.sendRedirect("./contentdetail.jsp?num="+adto.getNum());
%>