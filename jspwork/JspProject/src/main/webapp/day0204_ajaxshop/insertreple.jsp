<%@page import="shop.data.ShopRepleDAO"%>
<%@page import="shop.data.ShopRepleDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num = Integer.parseInt(request.getParameter("num"));
int star = Integer.parseInt(request.getParameter("star"));
String message = request.getParameter("message");

ShopRepleDTO dto = new ShopRepleDTO(num, star, message);
ShopRepleDAO dao = new ShopRepleDAO();

dao.insertReple(dto);
%>