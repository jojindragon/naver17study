<%@page import="shop.data.ShopDTO2"%>
<%@page import="shop.data.ShopDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="shop.data.ShopDAO2" />
<jsp:useBean id="dto" class="shop.data.ShopDTO2" />
<jsp:setProperty property="*" name="dto"/>

<%dao.updateShop(dto); %>
