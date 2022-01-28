<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL 연습</h1>
	
	<h4>값 출력</h4>
	${iVal}<br/>
	${lVal}<br/>
	${fVal}<br/>
	${bVal}<br/>
	${sVal}<br/>
	
	<h4>객체 출력</h4>
	---${obj}---<br/>
	${user.no}<br/>
	${user.name}<br/>
	
	<h4>map의 값 출력</h4>
	${m.iVal}<br/>
	${m.lVal}<br/>
	${m.fVal}<br/>
	${m.bVal}<br/>
	${m.sVal}<br/>
	
	<h4>산술 연산</h4>
	${3*4+6/2}<br/>
	${iVal+10}<br/>
	
	<h4>관계연산</h4>
	${iVal==10}<br/>
	${iVal<5}<br/>
	${obj==null}<br/>
	${empty obj}<br/>
	${obj!=null}<br/>
	${not empty obj}<br/>
	
	<h4>논리연산</h4>
	${iVal==10 && lVal<100 }<br/>
	${iVal==10||lVal<100}<br/>
	
	<h4>요청 파라미터</h4>
	${param.a+10}<br/>
	${param.email}<br/>
	
	
	

</body>
</html>