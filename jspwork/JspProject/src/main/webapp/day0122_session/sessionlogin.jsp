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
/* session에 저장된 체크 값 & 아이디 획득 */
String chksave = (String)session.getAttribute("chksave");
String myid = (String)session.getAttribute("myid");

if(chksave == null) {
	myid="";	
}
%>
<body>
<div class="login" style="margin: 30px;">
	<form action="./loginaction.jsp" method="post">
		<table class="table table-bordered" style="width: 300px;">
        	<tr>
            	<td colspan="2" align="center">
                	<label><input type="checkbox" name="chksave"
                	<%=chksave==null?"":"checked" %> />아이디 저장</label>
            	</td>
        	</tr>
        	<tr>
            	<th style="width: 100px;" class="table-info">아이디</th>
            	<td>
                	<input type="text" name="myId" class="form-control"
                		placeholder="Id" value="<%=myid%>" autofocus />
            	</td>
        	</tr>
        	<tr>
            	<th style="width: 100px;" class="table-info">비밀번호</th>
            	<td>
                <input type="password" name="myPass" class="form-control"
                	placeholder="password" />
            	</td>
        	</tr>
        	<tr>
            	<td colspan="2" class="table-danger" align="center">
                	<button type="submit" class="btn btn-default"
                		style="width: 150px;">회원로그인</button>
            	</td>
        	</tr>
		</table>
	</form>
</div>
</body>
</html>