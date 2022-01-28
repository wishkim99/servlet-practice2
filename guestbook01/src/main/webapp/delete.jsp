<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.poscoict.guestbook01.dao.guestbook01Dao,java.util.ArrayList,com.poscoict.guestbook01.vo.guestbook01Vo"%>

<%
request.setCharacterEncoding("utf-8");
	int no = Integer.valueOf(request.getParameter("no"));
	String password= (String)request.getParameter("password");

	
	guestbook01Vo vo = new guestbook01Vo();
	vo.setNo(no);
	vo.setPassword(password);                             
	
	new guestbook01Dao().delete(vo);
	
	response.sendRedirect("/guestbook01");
%>



