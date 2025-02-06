<%@page import="shop.data.ShopRepleDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int idx = Integer.parseInt(request.getParameter("idx"));

ShopRepleDAO dao = new ShopRepleDAO();
dao.deleteReple(idx);
%>