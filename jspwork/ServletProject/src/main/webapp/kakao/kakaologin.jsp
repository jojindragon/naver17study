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
a {
	text-decoration: none;
	color: black;
}
ul li {
	list-style: none;
}
div.kakaologin {
	width: 140px;
	height: 40px;
	border: 1px solid black;
	line-height: 40px;
	text-align: center;
	background-color: yellow;
	border-radius: 20px;
	cursor: pointer;
}

</style>
</head>
<body>
<div style="margin: 20px; width: 600px;">
	<ul>
	<script>
	let s= "";
	if(localStorage.loginok == null) {
		s+= `
		<li onclick="kakaoLogin();">
			<a href="javascript:void(0)">
		    	<div class="kakaologin">카카오 로그인</div>
			</a>
		</li>
		`;			
	} else {
		s+= `
		<li onclick="kakaoLogout();">
			<a href="javascript:void(0)">
				<div class="kakaologin">카카오 로그아웃</div>
				
				<h5 class="logininfo" style="float: right;">
					<img src="\${localStorage.photo}"
				 	 style="width:30px; height:30px; border-radius:100px"/>
				\${localStorage.writer}님 환영합니다!</h5>
			</a>
		</li>
		`;		
	}
	document.write(s);
	</script>
	</ul>
</div>

<!-- 카카오 스크립트 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('dfe54db3932e5033b03ddc1ea4107a2d'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response);
        	  console.log(response.properties.nickname); //닉네임
        	  console.log(response.properties.profile_image);
        	  
        	  // 로컬 스토리지에 닉네임, 썸네일, 로그인 상태 저장
        	  localStorage.writer = response.properties.nickname;
        	  localStorage.photo = response.properties.profile_image;
        	  localStorage.loginok = "success";
        	  location.reload();
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
//카카오로그아웃  
function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
        	console.log(response);
        	
        	localStorage.removeItem("writer");
        	localStorage.removeItem("photo");
        	localStorage.removeItem("loginok");
        	location.reload();
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }  
</script>
</body>
</html>