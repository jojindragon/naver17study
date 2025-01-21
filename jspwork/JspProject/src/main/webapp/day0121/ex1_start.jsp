<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>HTML, JSP 주석 확인</h3>
<!-- HTML 주석 -->
<%-- JSP 주석 --%>
<!-- 
<script type="text/javascript">
	document.write1("hello");
</script>
 -->
 <h4>이름: <%=name%></h4> <!-- 선언문의 변수는 위치가 어디든 출력 가능  -->
 
 <%!
 	//선언문 - 이곳에 변수를 등록하면 서블릿 변환 시 멤버변수로 등록
 	String name="홍길동";
 	
 %>
 <%
 	//스크립틀릿(scriptlet): 자바영역
 	//이곳에서 선언하는 변수는 서블릿 변환 시 지역변수로 등록(doGet의 지역변수)
 	
 	/* 변수를 브라우저에 출력하는 방법 2가지 */
 	//방법 1
 	out.print("<h2>이름: "+name+"</h2>");
 	
 %>
 <!-- 방법 2: 표현식을 이용한 Java 영역 변수 출력 -->
 <h4>이름: <%=name%></h4>
 
 <%-- <h5 style="color: blue;">주소 : <%=addr %></h5> --%>
 <%
 	String addr = "서울시 강남구";
 	// 자바 영역 내에서 선언된 지역변수는 선언부보다 아래쪽에서 사용!
 %>
 <h5 style="color: blue;">주소 : <%=addr %></h5>
 
 <!--
 	jsp 실행 => servlet(java 파일)으로 변환 => class 파일로 컴파일 
 	=> 클래스 파일 실행 => 브라우저 출력
 	
 	이클립스 내의 톰켓서버 위치 그 안에 현재 프로젝트가 배포되어있는 상황이라 복잡
  -->
 
</body>
</html>