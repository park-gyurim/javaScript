<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member.jsp</title>
</head>
<body>
<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
/* 	String aa=request.getParameter("지구를 지배하는 마왕");
	String bb=request.getParameter("밤새면서 그림그리기"); */
	out.println("장래희망 : 지구를 지배하는 마왕" +  "<br>");
	out.println("취미 : 밤새면서 그림그리기" +  "<hr/>");
	%>
</body>
</html>