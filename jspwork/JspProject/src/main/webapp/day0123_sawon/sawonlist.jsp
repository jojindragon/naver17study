<%@page import="sawon.data.SawonDto"%>
<%@page import="java.util.List"%>
<%@page import="sawon.data.SawonDao"%>
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

.tab th {
	background-color: #ddd;
	text-align: center;
}

.tab img.photo {
	width: 40px;
	height: 40px;
	border: solid 1px black;
	margin-right: 10px;
}
</style>
<script type="text/javascript">
$(function() {
	// 검색 버튼
	$("#btn-search").click(function() {
		//검색단어 가져오기
		let search = $("#search").val();
		
		// 목록 파일 이동 - 검색단어 get 전달
		location.href="./sawonlist.jsp?search="+search;
	});
	
	// 검색단어 입력 후 엔터를 누르면 검색
	$("#search").keyup(function(e) {
		if(e.keyCode==13) {
			// 검색 버튼 클릭 이벤트 강제호출 - trigger
			$("#btn-search").trigger("click");
		}
	});
	
});
</script>
</head>
<%
	// 검색 단어 읽기
	// 직접 실행: 넘어오는 값이 없다. - null 값이 된다.
	String search = request.getParameter("search");
	
	//dao 생성
	SawonDao dao = new SawonDao();

	//전체 데이터 가져오기
	List<SawonDto> list = dao.getAllDatas(search);	
%>
<body>
<div style="margin: 30px">
	<table class="tab table table-bordered" style="width: 450px;">
		<caption align="top">
			<b>[사원목록(<%=list.size() %>)명]</b>
			
			<button type="button" class="btn btn-sm btn-success"
				style="float: right;"
				onclick="location.href='./sawonform.jsp'">사원등록</button>
		</caption>
		<tr>
			<td colspan="4">
				<div class="input-group">
					<b>이름검색</b>&nbsp;&nbsp;
					<i class="bi bi-search"></i>&nbsp;&nbsp;&nbsp;
					<input type="text" id="search" placeholder="검색할 이름 입력"
					class="form-control" />
					&nbsp;
					<button type="button" class="btn btn-info btn-sm"
					 id="btn-search">검색</button>
				</div>				
			</td>
		</tr>
		<tr>
			<th width="50">번호</th>
			<th width="150">사원명</th>
			<th width="150">입사일</th>
			<th>상세보기</th>
		</tr>
		<%
		if(list.size()==0) {%>
			<tr height="50">
				<td colspan="4" align="center">
					<b>등록된 사원이 없습니다</b>
				</td>
			</tr>
		<%} else {
			int no = 0;
			for(SawonDto dto:list) {%>
				<tr align="center">
					<td><%=++no %></td>
					<td>
						<img src="<%=dto.getSphoto()%>" class="photo" />
						<%=dto.getSname() %>
					</td>
					<td><%=dto.getIpsaday() %></td>
					<td>
						<button type="button" class="btn btn-sm btn-info"
						onclick="location.href='./sawondetail.jsp?num=<%=dto.getNum()%>'">상세보기</button>
					</td>
				</tr>				
			<%}
		}%>
	</table>
</div>
</body>
</html>