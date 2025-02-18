<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>502 jsp study</title>
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Gaegu&family=Jua&family=Nanum+Pen+Script&family=Playwrite+AU+SA:wght@100..400&family=Single+Day&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<style>
body *{
	font-family: 'Jua';
}
form {
	width: 450px;
	border: 1px solid gray;
	border-radius: 10px;
	margin: 5px;
	padding-top: 10px;
	padding-left: 10px;
}
</style>     
</head>
<body>
<h2 class="alert alert-danger">문제2 - 폼단위 전송&삭제</h2>
<form action="./munje2process" method="post" enctype="multipart/form-data">
	제목: <input type="text" name="title" required="required"/><br><br>
	[파일]<br>
	<div id="files">
		<input type="file" name="upload" multiple="multiple"/>
		<i class="bi bi-plus-circle plus"></i>&nbsp;
		<i class="bi bi-dash-circle minus"></i>
	</div><br>
	<button type="submit" style="margin-bottom: 10px;">전송</button>
</form>
<script type="text/javascript">
$(document).on("click", ".plus", function() {
	let s = `
		<hr>
		<input type="file" name="upload" multiple="multiple"/>
	`;
	$("#files").append(s);
});

$(document).on("click", ".minus", function() {	
	$(this).next().remove();
	$(this).next().remove();
});
</script>
</body>
</html>