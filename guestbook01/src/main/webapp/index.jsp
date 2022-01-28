<%@page import="com.poscoict.guestbook01.dao.guestbook01Dao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poscoict.guestbook01.vo.guestbook01Vo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>

	<form action="/guestbook01/add.jsp" method="post">
		<table border=1 width=500>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 등록 "></td>
			</tr>
		</table>
	</form>

	<%
		guestbook01Dao dao = new guestbook01Dao();
		List<guestbook01Vo> list = dao.findAll();
			
		//List<guestbook01Vo> list1 =dao.findAll();
	%>
	<%
	int count = list.size();
			int index = 0;
			for(guestbook01Vo vo : list){
	%>
	<br>
	<table width=510 border=1>


		<tr>
			<td>[<%=count-index++ %>]</td>
			<td><%=vo.getName()%></td>
			<td><%=vo.getReg_date()%></td>

			<td><a href="/guestbook01/deleteform.jsp?no=<%=vo.getNo()%>">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4><%=vo.getMessage()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>