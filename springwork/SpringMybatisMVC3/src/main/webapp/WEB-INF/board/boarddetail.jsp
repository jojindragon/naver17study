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

/* 댓글 입력 디자인 */
#message {
	width: 100%;
	border: none;
	resize: none;
}
#message:focus {
	outline: none;
}

.replecamera {
	font-size: 1.4em;
	cursor: pointer;
	margin-left: 10px;
}
.replephoto img {
	width: 50px;
	height: 50px;
	border: 1px solid gray;
	border-radius: 10px;
}
.replephotodel {
	color: red;
	cursor: pointer;
	top: -10px;
	left: -10px;
}

/* 댓글 목록 디자인 */
.replelist {
	margin-top: 10px;
}

.replelist .day {
	color: #ccc;
	font-size: 13px;
}

.replelist .profile {
	width: 40px;
	height: 40px;
	border: 1px solid gray;
	border-radius: 100px;
	margin-right: 10px;
	float: left;
}

.replelist .photo {
	width: 120px;
	height: 120px;
	border: 1px solid gray;
	border-radius: 10px;
	cursor: pointer;
}

.toolbtn {
	cursor: pointer;
	color: gray;
}
.replemenu {
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 0.8em;
	width: 50px;
	padding: 10px;
	margin: 5px;
	text-align: center;
}
.replemenu span {
	cursor: pointer;
}
.replemenu span:hover {
	font: bold;
	font-size: 1.2em;
	text-decoration: underline;
}

</style>
<script type="text/javascript">
$(function() {
	replelist();
	
	// 댓글 메뉴 이벤트
	$(document).on("click", ".toolbtn", function() {
		//alert($(this).attr("num"));
		$(this).next().toggle();
	});
	
	// 댓글 삭제 이벤트
	
	// 댓글 수정 이벤트
	
});

// 댓글 출력
function replelist() {
	let totalcount = 0;
	$.ajax({
		type: "get",
		dataType: "json",
		data: {"idx":${dto.idx}},
		url: "./replecnt",
		success: function(res) {
			totalcount = res;
		}
	});

		
	$.ajax({
		type: "get",
		dataType: "json",
		data: {"idx":${dto.idx}},
		url: "./replelist",
		success: function(res) {
			//alert(res);
			let s="";
			
			if(totalcount == 0) {
				$(".replelist").html("댓글이 없습니다.");
				return;
			}
			
			s+=`
			<i class="bi bi-chat-dots">&nbsp;\${totalcount}</i>
			<br><br>
			`;
			$.each(res, function(i, item) {
				s+=`
				<div style="width: 500px;margin: 5px;">
				<img src="${naverurl}/member/\${item.profile}" class="profile"/>
				`;
				
				if("${loginid}"==`\${item.myid}`) {
					s+=`
					<i class="bi bi-three-dots toolbtn" style="float: right"></i>
					<div class="replemenu" style="float: right;display: none;">
						<span class="repleup" num="\${item.num}">수정</span><br>
						<span class="repledel" num="\${item.num}">삭제</span>
					</div>
					`;
				}
				
				s+=`
				<div style="display: inline-block;">
					<span>\${item.writer}</span><br>
					<pre style="font-size: 15px;">\${item.message}</pre>
				`;
				
				if(item.photo!=null) {
					s+=`
					<img src="${naverurl}/board/\${item.photo}" class="photo"/><br>
					`;
				}
				s+=`
					<span class="day">\${item.writeday}</span>
				`;
					
				s+="</div></div>";
			});
			$(".replelist").html(s);
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
			 onclick="boarddel()">삭제</button>
			<script type="text/javascript">
				function boarddel() {
					let chk = confirm("정말 삭제하시겠습니까?");
					let idx = ${dto.idx};
					let pageNum = ${pageNum};
					
					if(chk) {
						$.ajax({
							type: "get",
							dataType: "text",
							data: {"idx":idx},
							url: "./delete",
							success: function() {
								location.href="./list?pageNum="+pageNum;
							}
						});
					}
				}
			</script>
		</c:if>
		
		<button type="button" class="btn btn-info btn-sm" style="width: 80px;"
		 onclick="location.href='./list?pageNum=${pageNum}'">목록</button>
	</div>
	
	<hr style="color: #ccc;">
	<!-- 댓글: all ajax -->
	<div style="margin-top: 30px;width: 500px;border: 1px solid gray;">
		<b>${writer}</b><br>
		<textarea id="message" placeholder="댓글을 남겨보세요."></textarea>
		
		<div class="replephoto" style="margin-bottom:10px;padding-left: 10px;"></div>
		
		<input type="file" id="fileupload" name="upload" style="display: none;"/>
		<i class="bi bi-camera replecamera"></i>
		<span style="color: #ccc; margin-right: 10px; cursor: pointer;float: right;"
			 id="replesave">등록</span>
		
		<!-- 이벤트 -->	 
		<script type="text/javascript">
			$(".replecamera").click(function() {
				$("#fileupload").trigger("click");
			});
			
			$("#fileupload").change(function(e) {
				let form = new FormData();
				form.append("upload", e.target.files[0]);
				
				$.ajax({
					type: "post",
					dataType:"text",
					data:form,
					processData:false,
					contentType:false,
					url: "./repleupload",
					success: function(res) {
						let s = `
						<img src="${naverurl}/board/\${res}"/>
						<i class="bi bi-x-circle replephotodel" fname="\${res}"></i>
						`;
						
						$(".replephoto").html(s);
					}
				});
			})
			
			$(document).on("click", ".replephotodel", function() {
				let close = $(this);
				let fname = close.attr("fname");
				
				$.ajax({
					type: "get",
					dataType: "text",
					data: {"fname":fname},
					url: "./replephotodel",
					success: function() {
						close.prev().remove();
						close.remove();
					}
				});
			});
			
			$("#replesave").click(function() {
				let msg = $("#message").val();
				
				if(msg.trim()=="") {
					alert("댓글을 입력하세요!");
					return;
				}
				
				$.ajax({
					type: "post",
					dataType: "text",
					data: {"idx":${dto.idx}, "message":msg},
					url: "./addReple",
					success: function() {
						$("#message").val("");
						$(".replephoto").html("");
						replelist();
					}
				});
				
			});
		</script>
	</div>
	
	<div class="replelist"></div>
</div>

<!-- 댓글 사진 Modal -->
<div class="modal" id="Modal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">원본사진</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" style="text-align: center">
       	<img src="../../save/noimage.png" width="100%" id="modalimg"/>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" 
        data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<!-- 모달 끝 -->


</body>
</html>