<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String chksave = request.getParameter("chksave"); //on or null
String myid = request.getParameter("myId");
String mypass = request.getParameter("myPass");

if(myid.equals("angel") && mypass.equals("1234")) {
	/* 아이디 저장을 체크한 경우 */
	if(chksave != null) {
		session.setAttribute("myid", myid);
		session.setAttribute("chksave", "yes");
	} else {
		// 아이디 저장을 하지 않은 경우
		// 이전에 저장된 세션 삭제
		session.removeAttribute("chksave");
		session.removeAttribute("myid");
	}
	session.setAttribute("loginok", "yes");
	
	/* session 유지 시간 - 기본값: 30분 */
	session.setMaxInactiveInterval(60*60); // 1시간 유지(단위: 초)
	
	response.sendRedirect("./sessionmain.jsp");
} else {%>
	<script type="text/javascript">
		alert("아이디와 비번이 맞지 않다.");
		history.back();
	</script>
<%}
%>