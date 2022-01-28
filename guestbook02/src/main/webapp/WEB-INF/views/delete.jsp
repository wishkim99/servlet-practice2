<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.poscoict.guestbook.dao.guestbookDao,java.util.ArrayList,com.poscoict.guestbook.vo.guestbookVo"%>

<%
request.setCharacterEncoding("utf-8");
	int no = Integer.valueOf(request.getParameter("no"));
	String password= (String)request.getParameter("password");

	
	guestbookVo vo = new guestbookVo();
	vo.setNo(no);
	vo.setPassword(password);                             
	
	new guestbookDao().delete(vo);
	
	response.sendRedirect("/guestbook01");
%>



