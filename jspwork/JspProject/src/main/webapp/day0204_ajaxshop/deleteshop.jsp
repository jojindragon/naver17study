<%@page import="shop.data.ShopDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 1. num 읽기 */
int num = Integer.parseInt(request.getParameter("num"));
/* 2. dao 선언 */
ShopDAO2 dao = new ShopDAO2();
/* 3. 삭제 메서드 호출(deleteShop(int num)) */
dao.deleteShop(num);
%>