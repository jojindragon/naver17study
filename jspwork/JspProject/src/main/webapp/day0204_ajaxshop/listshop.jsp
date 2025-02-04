<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="shop.data.ShopDTO2"%>
<%@page import="java.util.List"%>
<%@page import="shop.data.ShopDAO2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int order = Integer.parseInt(request.getParameter("order"));
ShopDAO2 dao = new ShopDAO2();
List<ShopDTO2> list = dao.getAllSangpums(order);

JSONArray arr = new JSONArray();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

for(ShopDTO2 dto:list) {
	JSONObject ob = new JSONObject();
	ob.put("num", dto.getNum());
	ob.put("sangpum", dto.getSangpum());
	ob.put("sphoto", dto.getSphoto());
	ob.put("scolor", dto.getScolor());
	ob.put("sprice", dto.getSprice());
	ob.put("ipgoday", dto.getIpgoday());
	ob.put("scnt", dto.getScnt());
	ob.put("writeday", sdf.format(dto.getWriteday()));
	
	arr.add(ob);
}
%>
<%=arr %>