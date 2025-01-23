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
<body>
<div style="margin: 30px;">
	<form action="./ex4_action.jsp" method="post">
		<table class="tab table table-bordered" style="width: 300px;">
			<tr>
				<th width="100">아이디</th>
				<td>
					<input type="text" name="id" class="form-control"
						required="required" value="angel" />
				</td>
			</tr>
			<tr>
				<th width="100">비밀번호</th>
				<td>
					<input type="password" name="pass" class="form-control"
						required="required" value="1234" />
				</td>
			</tr>
			<tr>
				<th width="100">이름</th>
				<td>
					<input type="text" name="myname" class="form-control"
						required="required" value="강호동" />
				</td>
			</tr>
			<tr>
				<th width="100">운전면허</th>
				<td>
					<label>
						<!-- 
						checkbox: value가 없을 경우 => "on" or null
								  value가 지정 => 체크할 경우 "value 값"			
					 	 -->
						<input type="checkbox" name="driver" value="yes" />&nbsp;운전면허
					</label>
				</td>
			</tr>
			<tr>
				<th width="100">주거지</th>
				<td>
					<label>
						<input type="radio" name="homeaddr" value="서울"
							checked="checked" />&nbsp;서울&nbsp;&nbsp;
					</label>
					<label>
						<input type="radio" name="homeaddr" value="경기도" />&nbsp;경기도
					</label>
					<br>
					<label>
						<input type="radio" name="homeaddr" value="제주도" />&nbsp;제주도
					</label>
					<label>
						<input type="radio" name="homeaddr" value="부산" />&nbsp;부산
					</label>
				</td>
			</tr>
			<tr>
				<th width="100">취미</th>
				<td>
					<label>
						<input type="checkbox" name="hobby" value="게임" />&nbsp;게임
					</label>
					<label>
						<input type="checkbox" name="hobby" value="낚시" />&nbsp;낚시
					</label>
					<br>
					<label>
						<input type="checkbox" name="hobby" value="여행" />&nbsp;여행
					</label>
					<label>
						<input type="checkbox" name="hobby" value="음악감상" />&nbsp;음악감상
					</label>
				</td>
			</tr>
			<tr>
				<th width="100">기호식품</th>
				<td>
					<select class="form-select" name="myfood">
						<option value="2.jpg">닭꼬치</option>
						<option value="4.jpg">소고기카레</option>
						<option value="11.jpg">망고빙수</option>
						<option value="10.jpg">햄마요덮밥</option>
					</select>
				</td>
			</tr>
			<tr>
				<th width="100">글자색</th>
				<td>
					<input type="color" name="fcolor" value="#ccffcc" />
				</td>
			</tr>
			<tr>
				<th width="100">생년월일</th>
				<td>
					<input type="date" name="mybirth" value="2010-01-01" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<!-- <button type="submit">서버에 전송</button> -->
					<!-- type이 image인 경우도 submit에 해당 -->
					<input type="image" value="서버에 전송"
					 	src="../image/mycar/mycar13.png"
					 	style="width: 100px" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>