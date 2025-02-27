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
#writerPhoto {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
	border-radius: 100px;
	margin-right: 10px;
}
.day {
	color: gray;
	font-size: 13px;
}
</style>
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
<div style="margin: 30px;">
	<h3><b>${dto.subject}</b></h3>
	<div class="input-group">
		<img src="${wfronturl}/member/${wphoto}${wbackurl}"
		 id="writerPhoto" onerror="this.src='../save/noimage.png'"/>
		<div>
			<span>${dto.writer}</span><br>
			<span class="day">
				<fmt:formatDate value="${dto.writeday}"
			 	 pattern="yyyy.MM.dd HH:mm"/>
				&nbsp;&nbsp;조회&nbsp;${dto.readcount}
			</span>
		</div>
	</div>
	<hr style="color: #ccc;">
	<pre style="margin-top: 30px;font-size: 15px;">${dto.content}</pre>
	<div style="margin-top: 30px;">
		<c:forEach var="photo" items="${dto.photos}">
			<img src="${naverurl}/board/${photo}"
			 style="max-width: 300px;max-height: 300px;"/>
		</c:forEach>
	</div>
	
	<div style="margin-top: 30px;">
		<button type="button" class="btn btn-sm btn-outline-success"
		 style="width: 80px;"
		 onclick="location.href='./writeform'">
			<i class="bi bi-pencil-fill">&nbsp;글쓰기</i> 
		</button>
		
		<button type="button" class="btn btn-sm btn-outline-secondary"
		 style="width: 80px;"
		 onclick="location.href='./writeform?idx=${dto.idx}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&pageNum=${pageNum}'">
			<i class="bi bi-pencil-fill">&nbsp;답글</i> 
		</button>
		
		<c:if test="${sessionScope.loginid==dto.myid}">
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
		 	 onclick="location.href='./updateform?idx=${dto.idx}&pageNum=${pageNum}'">수정</button>
		 	 
			<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
			 onclick="location.href='./delete?idx=${dto.idx}&pageNum=${pageNum}'">삭제</button>
		</c:if>
		
		<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
		 onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
	</div>
</div>
</body>
</html>