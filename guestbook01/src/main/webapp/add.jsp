<%@page import="com.poscoict.guestbook01.vo.guestbook01Vo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.poscoict.guestbook01.dao.guestbook01Dao,java.util.ArrayList,com.poscoict.guestbook01.vo.guestbook01Vo"%>

<%
request.setCharacterEncoding("utf-8");
	String name= (String)request.getParameter("name");
	String password= (String)request.getParameter("password");
	String message = (String)request.getParameter("message");

	
	guestbook01Vo vo = new guestbook01Vo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);                             
	
	new guestbook01Dao().insert(vo);
	
	response.sendRedirect("/guestbook01");
%>
