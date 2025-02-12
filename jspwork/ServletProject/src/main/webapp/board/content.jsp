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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body *{
	font-family: 'Jua';
}
.day {
	color: gray;
	font-size: 13px;
}
.smallphoto {
	width: 45px;
	height: 45px;
	border: 1px solid gray;
	border-radius: 100px;
	margin-right: 10px;
	cursor: pointer;
}
</style>
<script type="text/javascript">
$(function() {
	$(".btn").addClass("btn-sm btn-outline-secondary").css("width", "100px");
});
</script>
</head>
<body>
<div style="margin: 20px;width: 600px;">
	<h1><b>${dto.subject}</b></h1>
	<div>
		<img src="${dto.photo}" class="smallphoto" align="left"
		 data-bs-toggle="modal" data-bs-target="#photoModal"/>
		<span>${dto.writer}</span><br>
		<span class="day">
			<fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/>
			&nbsp;&nbsp;&nbsp;
			조회 ${dto.readcount}
		</span>
	</div>
	<hr>
	<pre style="font-size: 17px;">${dto.content}</pre>
	<div style="margin-top: 50px;">
		<button type="button" class="btn"
		 onclick="location.href='./writeform'">글쓰기</button>
		 
		 <button type="button" class="btn"
		  onclick="location.href='./list'">목록</button>
		 
		<button type="button" class="btn"
		 onclick="location.href='./writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}'">답글</button>
		
		<button type="button" class="btn"
		 onclick="loction.href='./deletepassform?num=${dto.num}'">삭제</button>
	</div>
</div>

<!-- Modal - 상품등록 -->
<div class="modal" id="photoModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">${dto.writer}님 프로필 사진</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <div class="modal-body" style="text-align: center">
      	<img src="${dto.photo}"/>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-danger"
         data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>