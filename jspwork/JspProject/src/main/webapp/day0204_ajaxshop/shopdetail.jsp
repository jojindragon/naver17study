<%@page import="java.text.SimpleDateFormat"%>
<%@page import="shop.data.ShopDTO2"%>
<%@page import="shop.data.ShopDAO2"%>
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body * {
	font-family: 'Jua';
}

div.scolor {
	width: 30px;
	height: 30px; 
	border: solid 1px black;
	border-radius: 100px;
}

button {
	width: 100px;
	margin-right: 20px;
}

.btn {
	width: 100px;
}
.replelist i.close {
	cursor: pointer;
	margin-right: 10px;
	float: right;
	color: red;
}
.replelist b {
	margin-left: 5px;
}
.replelist div {
	font-size: 13px;
	font-family: 'Gaegu';
}
.replelist .day {
	font-size: 12px;
	color: gray;
}

.star {
	font-size: 13px;
}
.starfill {
	font-size: 13px;
	color: gold;
}
</style>
<%
/* 1. num 읽기 */
int num = Integer.parseInt(request.getParameter("num"));
/* 2. dao 선언 */
ShopDAO2 dao = new ShopDAO2();
/* 3. num에 해당하는 dto 얻기 - dao 메소드 추가(getSangpum(int num)) */
ShopDTO2 dto = dao.getSangpum(num);
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<script type="text/javascript">
$(function() {
	list();
	
	$("#btnreple").click(function() {
		let num=<%=num %>;
		let star = $(".selstar").val();
		let msg = $("#message").val();
		
		$.ajax({
			type: "get",
			dataType: "html",
			data: {"num":num, "star":star, "message":msg},
			url: "./insertreple.jsp",
			success: function(res) {
				list();

				$(".selstar").val(5);
				$("#message").val("");
			}
		});
	});
	
	/* 상품평 삭제 */
	$(document).on("click", ".close", function() {
		let idx = $(this).attr("idx"); 
			
		$.ajax({
			type: "get",
			dataType: "html",
			data: {"idx":idx},
			url: "./deletereple.jsp",
			success: function(res) {
				list();				
			}
		});
	});
	
	/* 상품평 나타내기&숨기기 */
	$(".replelist>b").click(function() {
		$(this).next().slideToggle('fast');
	});
});

function list() {
	$.ajax({
		type: "get",
		dataType: "json",
		data: {"num":<%=num %>},
		url: "./listreple.jsp",
		success: function(res) {
			let n=$(res).length;
			$(".replelist>b").text("총 "+n+"개의 리뷰");
			
			// 상품평 목록 출력
			let s="";
			$.each(res, function(idx, ele) {
				s+="<div style='width: 180px;'>";
				
				for(let i=1; i<=5; i++) {
					if(i<=ele.star)
						s+=`<i class="bi bi-star-fill starfill"></i>`;
					else
						s+=`<i class="bi bi-star star"></i>`;
				}
				
				s+=`
				<span class="day">\${ele.writeday}</span><br>
				<b>\${ele.message}</b>
				<i class="bi bi-x-lg close" idx="\${ele.idx}"></i>
				`;

				s+="</div><br>";
			});
			
			$(".replelist>div").html(s);
		}
	});	
}
</script>
</head>
<body>
<!-- table을 이용해서 상세 페이지 만들기, 맨 아래에 수정&삭제&목록 버튼 넣기 -->
<div style="margin: 20px;width: 500px;">
	<h5 class="alert alert-success" style="text-align: center;">
	[<%=dto.getSangpum() %> 상세 목록]</h5>
	
	<table class="table table-bordered">
		<tr>
			<td width="100">
				<img src="<%=dto.getSphoto() %>"
				 width="230" height="300" border="1" />
			</td>			
			<td valign="middle">
				<h6>상품명: <%=dto.getSangpum() %></h6>
				<h6>가격: <%=dto.getSprice() %></h6>
				<h6>개수: <%=dto.getScnt() %></h6>
				<h6>입고일: <%=dto.getIpgoday() %></h6>
				<h6>등록일: <%=sdf.format(dto.getWriteday()) %></h6>
				<h6>[색깔]</h6>
				<div class="scolor"
				 style="background-color: <%=dto.getScolor()%>"></div>
			</td>
		</tr>
		<tr><!-- 리뷰 등록  -->
			<td colspan="2">
				<h6><b>상품평 등록</b></h6>
				<div class="repleform input-group">
					<select class="form-select selstar"
					 style="width: 70px;">
						<option value="5">별점 5</option>
						<option value="4">별점 4</option>
						<option value="3">별점 3</option>
						<option value="2">별점 2</option>
						<option value="1">별점 1</option>
					</select>&nbsp;
					<input type="text" id="message" class="form-control"
					 placeholder="상품 평가" style="width: 200px;" />
					 &nbsp;
					<button type="button" class="btn btn-sm btn-info"
					 id="btnreple">등록</button>
				</div>
				<div class="replelist" style="margin-top: 10px;">
					<b style="cursor: pointer;">0</b>
					<div style="margin-left: 10px;">1</div>
				</div>
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<button type="button"
				 class="btn btn-outline-success"
	 			 id="btnupdate"
	 			 data-bs-toggle="modal"
		 		 data-bs-target="#shopUpdateModal">수정</button>
	 			 
				<button type="button"
				 class="btn btn-outline-danger"
	 			 id="btndelete">삭제</button>
	 			 
				<button type="button"
				 class="btn btn-outline-info"
	 			 onclick="location.href='./shopmain.html'">목록</button>
			</td>
		</tr>
	</table>
	
<!-- 상품 수정 다이얼로그 -->
<div class="modal" id="shopUpdateModal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">상품 수정</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
       
       <!-- 이번에 수정은 폼단위로 값을 얻어보자 -->
       <form id="shopupdatefrm">
       	  <!-- hidden -->
       	  <input type="hidden" name="num" value="<%=num %>">
       	  
		<table class="table table-bordered">
			<tr>
				<td width="100" style="background-color: lightgray;">상품사진</td>
				<td>
					<select id="sphoto" name="sphoto" class="form-select">
						  <script>
						  	for(let i=1;i<=34;i++){
						  		let s="";
						  		let sphoto=`../image/photo2/\${i}.\${i==24?"gif":"jpg"}`;
						  		let dbphoto="<%=dto.getSphoto()%>";
						  		if(sphoto==dbphoto)
						  			s=`<option value='\${sphoto}' selected>상품 \${i}</option>`;
						  		else 
						  			s=`<option value='\${sphoto}'>상품 \${i}</option>`;
						  		document.write(s);
						  	}
						  </script>		
					 </select>
					 <br>
					<img src="" class="shopphoto" width="100">
					
					<script type="text/javascript">
						$(".shopphoto").attr("src",$("#sphoto").val());
						
						//이벤트
						$("#sphoto").change(function(){
							$(".shopphoto").attr("src",$(this).val());
						});
					</script>
			 </td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품명</td>
				<td>
					<input type="text" name="sangpum" id="sangpum"
				class="form-control" value="<%=dto.getSangpum()%>">	
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품색상</td>
				<td>
					<input type="color" name="scolor" id="scolor"
						 value="<%=dto.getScolor()%>">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품가격</td>
				<td>
					<input type="text" name="sprice" id="sprice" 
					  class="form-control" value="<%=dto.getSprice()%>">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">상품갯수</td>
				<td>
					<input type="number" name="scnt" id="scnt" 
					  class="form-control" min="1" max="10" 
					  value="<%=dto.getScnt()%>">
				</td>
			</tr>
			<tr>
				<td style="background-color: lightgray;">입고일</td>
				<td>
					<input type="date" name="ipgoday" id="ipgoday" 
					  class="form-control" value="<%=dto.getIpgoday()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="submit"  data-bs-dismiss="modal"
					style=width:120px;"
					class="btn btn-sm btn-success">수정하기</button>
				</td>
			</tr>			
		</table>
			
       </form>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" 
        data-bs-dismiss="modal">Close</button>
      </div>

    </div>
  </div>
</div>
<!-- 상품수정폼 끝 -->

	<script type="text/javascript">
	$("#btndelete").click(function() {
		/* confirm으로 확인 후 삭제 */
		let ans = confirm("현재 상품을 삭제하시겠습니까?");	
		/* ajax함수 이용
		   data: num
		   success: 목록 이동
		 */
		if(ans) {
			$.ajax({
				type: "get",
				dataType: "html",
				data: {"num":<%=num %>},
				url: "./deleteshop.jsp",
				success: function(res) {
					location.href="./shopmain.html";
				}
			});
		}
	});
	
	$("#shopupdatefrm").submit(function(e) {
		e.preventDefault();
		let d = $(this).serialize();
		
		$.ajax({
			type: "get",
			dataType: "html",
			data: d,
			url: "./updateshop.jsp",
			success: function(res) {
				location.reload();
			}
		});
	});
	</script>
</div>
</body>
</html>