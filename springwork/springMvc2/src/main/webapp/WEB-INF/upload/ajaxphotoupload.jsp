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
#photoupload {
	display: none;
}
#myphoto {
	width: 200px;
	height: 200px;
	border: 1px solid gray;
	border-radius: 100px;
}
.mycamera {
	font-size: 1.5em;
	cursor: pointer;
	border: 1px solid gray;
	border-radius: 100px;
	padding: 5px;
	background-color: #ddd;
	
	position: relative;
	top: 70px;
	left: -50px;
}
.mycamera:hover {
	background-color: gray;
}

</style>     
</head>
<body>
<div style="margin: 50px;">
	<input type="file" id="photoupload"/>
	
	<img src="" id="myphoto" onerror="this.src='./image/noimage.png'"/>
	
	<i class="bi bi-camera mycamera"></i>
</div>
<script type="text/javascript">
$(".mycamera").click(function() {
	$("#photoupload").trigger("click");
});

$("#photoupload").change(function(e) {
	let form = new FormData();
	// 선택한 파일 1개를 의미
	/* form.append("upload", $("#photoupload")[0].files[0]); */
	form.append("upload", e.target.files[0]);
	
	/*
	 processData:false - 서버에 전달하는 데이터는 query string 형태로 전달
	 				파일 전송의 경우 이를 하지 않아야 함 - 설정: false
	 contentType:false - enctype이 원래 기본값이 application/x-www...
	 				이를 multipart/form-data로 변경해준다.
	 */
	 $.ajax({
		type: "post",
		dataType: "json",
		url: "./oneupload",
		processData: false,
		contentType: false,
		data: form,
		success: function(res) {
			$("#myphoto").attr("src", "./save/"+res.photo);
		}
	 });
	
});
</script>
</body>
</html>