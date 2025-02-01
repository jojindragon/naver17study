<?xml version="1.0" encoding="UTF-8"?>
<%@page import="shop.data.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.data.ShopDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
	ShopDao dao = new ShopDao();
	String search = request.getParameter("search");
	List<ShopDto> list = dao.getAllDatas(search);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	for(ShopDto dto:list) {%>
	<shop idx="<%=dto.getIdx() %>">
		<sangpum><%=dto.getSangpum() %></sangpum>
		<su><%=dto.getSu() %></su>
		<danga><%=dto.getDanga() %></danga>
		<ipgoday><%=sdf.format(dto.getIpgoday()) %></ipgoday>		
	</shop>
	<%}
%>
</data>