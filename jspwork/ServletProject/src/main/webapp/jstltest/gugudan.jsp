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
</style>
</head>
<body>
<div style="margin: 10px;">
	<h5 class="alert alert-info">JSTL 구구단</h5>
	<table class="table table-bordered" style="text-align: center;">
		<tr>
		<c:forEach var="gugu" begin="2" end="9">
			<td style="background-color: orange">${gugu }단</td>
		</c:forEach>
		</tr>
		<c:forEach var="i" begin="1" end="9">
		<tr>
			<c:forEach var="gugu" begin="2" end="9">
			<td>${gugu }X${i }=${gugu*i }</td>
			</c:forEach>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>