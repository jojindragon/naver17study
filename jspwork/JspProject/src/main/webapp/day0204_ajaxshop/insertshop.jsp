<%@page import="shop.data.ShopDTO2"%>
<%@page import="shop.data.ShopDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="sdao" class="shop.data.ShopDAO2" />
<jsp:useBean id="sdto" class="shop.data.ShopDTO2" />
<jsp:setProperty property="*" name="sdto" />
<%sdao.insertShop(sdto); %>

<%-- <%
String sangpum = request.getParameter("sangpum");
String sphoto = request.getParameter("sphoto");
String scolor = request.getParameter("scolor");
int scnt = Integer.parseInt(request.getParameter("scnt"));
int sprice = Integer.parseInt(request.getParameter("sprice"));
String ipgoday = request.getParameter("ipgoday");

ShopDTO2 dto = new ShopDTO2();

dto.setSangpum(sangpum);
dto.setSphoto(sphoto);
dto.setScolor(scolor);
dto.setScnt(scnt);
dto.setSprice(sprice);
dto.setIpgoday(ipgoday);

ShopDAO2 dao = new ShopDAO2();
dao.insertShop(dto);
%> --%>