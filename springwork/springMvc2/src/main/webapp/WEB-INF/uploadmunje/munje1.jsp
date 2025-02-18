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
#subject {
	margin-bottom: 10px; 
}
</style>     
</head>
<body>
<div style="margin: 20px;width: 500px;">
	<h2 class="alert alert-danger">Ajax 업로드 문제 1</h2>
	제목: <input type="text" id="subject" placeholder="제목 입력"/><br>
	사진: <input type="file" id="photoup"/>
	<hr>
	<h2 class="title"></h2>
	<div class="photo"></div>
</div>
<script type="text/javascript">
$("#photoup").change(function(e) {
	let subject = $("#subject").val();
	//alert(subject);
	if(subject.trim() === '') {
		alert("제목 먼저 입력!");
		location.reload();
	} else {
		let form = new FormData();
		//alert(e.target.files[0]);
		form.append("subject", subject);
		form.append("upload", e.target.files[0]);
		
		$.ajax({
			type: "post",
			dataType: "json",
			url: "./munje1process",
			processData: false,
			contentType: false,
			data: form,
			success: function(res) {
				let img = `
				<img src="./save/\${res.photo}"/>
				`;
				
				$(".title").html(res.subject);
				$(".photo").html(img);
			}
		 });
	}
	
});
</script>
</body>
</html>