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
.tabform tbody th {
	background-color: orange;
}
.photos img {
	width: 50px;
	height: 50px;
	margin: 5px;
	border: 1px solid gray;
	border-radius: 10px;
}
.photoplus {
	float: right;
	margin-right: 10px;
	cursor: pointer;
}
.photodel {
	cursor: pointer;
	font-size: 1.5em;
	position: relative;
	left: -15px;
	top: -20px;
	color: red;
}
</style>
<script type="text/javascript">
$(function() {
	photolist();
	
	// 사진 추가
	$(".photoplus").click(function() {
		$("#upload").trigger("click");
	});
	$("#upload").change(function(e) {
		let form = new FormData();
		
		for(let i=0; i<e.target.files.length; i++) {
			form.append("upload", e.target.files[i]);
		}
		form.append("idx", ${dto.idx});
		
		$.ajax({
			type: "post",
			dataType: "text",
			url: "./photoUp",
			data: form,
			processData: false,
			contentType: false,
			success: function() {
				photolist();
			}
		});
	});
	
	// 개별 사진 삭제
	$(document).on("click", ".photodel", function() {
		let num = $(this).attr("num");
		
		//alert(num);
		$.ajax({
			type: "post",
			dataType: "text",
			url: "./photoDel",
			data: {"num":num},
			success: function() {
				photolist();
			}
		});
		
	});
});

function photolist() {
	let idx = ${dto.idx};
	let furl = `${fronturl}`;
	let burl = `${backurl}`;
	
	$.ajax({
		type: "get",
		dataType: "json",
		data: {"idx":idx},
		url: "./photolist",
		success: function(res) {
			let s="";
			$.each(res, function(i, item) {
				s+= `
				<img src="\${furl}/board/\${item.filename}\${burl}"				 
				 onerror="this.src='../save/noimage.png'"/>
				<i class="bi bi-x photodel" num="\${item.num}"></i>
				`;
			});
			
			$(".photolist").html(s);
		}
	});
}
</script>
</head>
<body>
<!-- 로그인을 안 할 경우: 경고 후 이전페이지 이동 -->
<c:if test="${sessionScope.loginstatus==null}">
	<script type="text/javascript">
		alert("회원게시판입니다\n먼저 로그인을 해주세요.");
		history.back();
	</script>
</c:if>
<jsp:include page="../../layout/title.jsp"/>

<div style="margin: 20px; width: 600px;">
	<form action="./update" method="post" enctype="multipart/form-data">
		<input type="hidden" name="idx" value="${dto.idx}"/>
		<input type="hidden" name="pageNum" value="${pageNum}"/>
		<!-- 답글을 위한 hidden -->
		<table class="tabform table table-bordered">
			<tbody>
				<tr>
					<th width="100">제 목</th>
					<td>
						<input type="text" name="subject" class="form-control"
						 value="${dto.subject}"
						 required="required" autofocus="autofocus"/>
					</td>
				</tr>
				<tr>
					<th width="100">사 진</th>
					<td>
					<!-- 사진 리스트 띄우기 -->
					<div class="photolist"></div><br>
					<input type="file" name="upload" class="form-control"
					 id="upload" multiple="multiple" style="display: none;"/>
					<i class="bi bi-plus-circle photoplus">&nbsp;추가</i>
					</td>
				</tr>
				<tr>
					<th width="100">내 용</th>
					<td>
						<textarea name="content" class="form-control"
						 required="required"
						 style="width: 100%;height: 150px;">${dto.content}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-outline-secondary"
						 style="width: 100px;">수정</button>
						 
						<button type="button" class="btn btn-outline-secondary"
						 style="width: 100px;"
						 onclick="location.href='./detail?idx=${dto.idx}&pageNum=${pageNum}'">이전으로</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</div>
</body>
</html>