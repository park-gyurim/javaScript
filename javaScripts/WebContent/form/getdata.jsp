<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getdata.jsp</title>
</head>
<body>
	<% 
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String name=request.getParameter("myname");
	String major=request.getParameter("mymajor");
	out.println("이름 :" + name + "<br>");
	out.println("전공 :" + major + "<hr/>");
	%>
</body>
</html>