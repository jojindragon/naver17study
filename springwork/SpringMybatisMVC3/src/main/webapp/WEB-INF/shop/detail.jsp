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

.colorbox {
	display: inline-block;
	width: 30px;
	height: 30px;
	border: 1px solid black;
	border-radius: 100px;
}
.selimg {
	cursor: pointer;
	width: 100px;
	height: 100px;
	border: 1px solid gray;
	margin: 5px;
}
#mainimg {
	width: 400px;
	height: 400px;
	border: 3px solid black;
}
#photoupload {
	display: none;
}
.addphoto {
	font-size: 1.5em;
	cursor: pointer;
	margin-left: 10px;
	margin-right: 10px;
}
.replelist {
	margin: 10px 10px;
}

.repleimg {
	width: 50px;
	height: 50px;
	cursor: pointer;
	margin: 5px;
}
.msg {
	margin: 5px;
}
.date {
	font-size: 0.8em;
	color: gray;
	margin: 5px;
}
.likes {
	color: hotpink;
	margin-top: 5px;
	margin-left: 10px;
	margin-right: 5px;
	cursor: pointer;
}
.del {
	float: right;
	color: red;
	font-size: 1.2em;
	cursor: pointer;
}
</style>
<script type="text/javascript">
$(function() {
	replelist(); // 처음 로딩 시 댓글 출력
	
	// 카메라 아이콘 이벤트
	$(".addphoto").click(function() {
		$("#photoupload").trigger("click");
	});
	// 파일 업로드 이벤트
	let file;
	$("#photoupload").change(function(e) {
		file = e.target.files[0];
		console.log(file);
	});
	
	// 댓글 등록버튼 이벤트
	$("#btnaddreple").click(function() {
		let msg = $("#message").val();
		if(msg.trim() == "") {
			alert("댓글을 입력해라.");
			return;
		}
		
		if(file == null) {
			alert("사진을 선택해주세요.");
			return;
		}
		
		let form = new FormData();
		form.append("upload", file);
		form.append("message", msg);
		form.append("num", ${dto.num});
		
		$.ajax({
			type: "post",
			dataType: "text",
			url: "./addreple",
			data: form,
			processData: false,
			contentType: false,
			success: function() {
				$("#message").val("");
				file = null;
				replelist();
			}
		});
		
	});
	
	// 댓글 삭제 이벤트
	$(document).on("click", ".del", function() {
		let pname = $(this).attr("pname");
		let idx = $(this).attr("idx");
		//alert(pname+" "+idx);
		
		$.ajax({
			type: "post",
			dataType: "text",
			url: "./repledelete",
			data: {"idx":idx, "pname":pname},
			success: function() {
				replelist();
			}
		});
	});
	
	// 추천 증가 이벤트
	$(document).on("click", ".likes", function() {
		//alert("추천!"+$(this).attr("idx"));
		let idx = $(this).attr("idx");
		$.ajax({
			type: "post",
			dataType: "text",
			url: "./pluslikes",
			data: {"idx":idx},
			success: function() {
				replelist();
			}
		});
	});
	
	// modal 이벤트
	$(document).on("click", ".repleimg", function() {
		$("#modalimg").attr("src", $(this).attr("src"));
	});
	
});

/* 출력 */
function replelist() {
	$.ajax({
		type: "get",
		dataType: "json",
		url: "./replelist",
		data: {"num":${dto.num}},
		success: function(res) {
			let s="";
			
			if(res.length == 0) {
				s+= "댓글이 없습니다.";
			} else {
				$.each(res, function(idx, ele) {
					s+=`
					<hr>
					<div class="input-group">
						<img src="../../save/\${ele.photo}"
						 class="repleimg"
				 		 data-bs-toggle="modal"
					 	 data-bs-target="#photoModal"/>
						<p class="msg">\${ele.message}</p>
						<span class="date">\${ele.writetime}</span>
						<i class="bi bi-heart likes" idx="\${ele.idx}">추천&nbsp;\${ele.likes}</i>
						<i class="bi bi-x del" idx="\${ele.idx}"
						 pname="\${ele.photo}"></i>
					</div>
					`;
				});
			}
			
			$(".replelist").html(s);
		}
	});
}
</script>  
</head>
<body>
<div style="margin: 20px;width: 500px;">
	<table>
		<tr>
			<td width="120">
			<c:forTokens items="${dto.sphoto}" delims="," var="photos">
				<img src="../../save/${photos}" class="selimg"/>
			</c:forTokens>
			</td>
			<td>
				<img src="../../save/${dto.mainPhoto}" id="mainimg"
				 onerror="this.src='../../save/noimage.png'"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div style="margin: 20px 100px;font-size: 17px;">
					<mark>상품명: ${dto.sangpum}</mark><br>
					가격:<fmt:formatNumber value="${dto.sprice}" type="number"/>원<br>
					갯수: ${dto.scnt} 개<br>
					색상: ${dto.scolor}&nbsp;
					<div class="colorbox"
					 style="background-color: ${dto.scolor}"></div><br>
					입고일: ${dto.ipgoday}<br>
					등록일: <fmt:formatDate value="${dto.writeday}" pattern="yyyy-MM-dd HH:mm"/> 
				</div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<div class="repleform input-group" style="width: 600px;">
					<input type="text" id="message" class="form-control"
					 style="width: 400px;" placeholder="댓글 입력"/>

					<input type="file" id="photoupload"/>
					<i class="bi bi-camera-fill addphoto"></i>
					<button type="button" class="btn btn-sm btn-info"
					 id="btnaddreple">등록</button>
				</div>
				<div class="replelist">123</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" class="btn btn-sm btn-outline-secondary"
				 style="width: 90px"
				 onclick="location.href='./addform'">상품등록</button>

				<button type="button" class="btn btn-sm btn-outline-secondary"
				 style="width: 90px"
				 onclick="location.href='./list'">목록</button>

				<button type="button" class="btn btn-sm btn-outline-secondary"
				 style="width: 90px"
				 onclick="location.href='./updateform?num=${dto.num}'">수정</button>

				<button type="button" class="btn btn-sm btn-outline-secondary"
				 style="width: 90px"
				 onclick="sangdel(${dto.num})">삭제</button>
				 
				<button type="button" class="btn btn-sm btn-outline-secondary"
				 style="width: 90px"
				 onclick="location.href='./photos?num=${dto.num}'">사진수정</button>
			</td>
		</tr>
	</table>
	
</div>
<script type="text/javascript">
$(".selimg").click(function() {
	let img = $(this).attr("src");
	$("#mainimg").attr("src", img);
});

function sangdel(num) {
	let ans = confirm("해당 게시물을 삭제하려면 [확인]을 눌러주세요");
	if(ans) {
		location.href="./delete?num="+num;
	}
}
</script>
<!-- 댓글 사진 모달 -->
<div class="modal" id="photoModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">댓글 아이콘</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body" style="text-align: center">
       	<img src="../../save/noimage.png" width="200" id="modalimg"/>
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