<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--자바 빈즈를 이용해서 처리하기
	useBean - dao & dto 선언
	setProperty - 전체 데이터 읽기
 -->
<jsp:useBean id="dao" class="simpleboard.data.SimpleBoardDao" />
<jsp:useBean id="dto" class="simpleboard.data.SimpleBoardDto" />
<jsp:setProperty property="*" name="dto"/>
<%
	// dao의 updateBoard 호출
	dao.updateBoard(dto);
	// 상세보기로 이동
	response.sendRedirect("./contentdetail.jsp?num="+dto.getNum());
%>    
