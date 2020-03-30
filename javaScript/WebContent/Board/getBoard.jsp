<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.yedam.board.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard.jsp</title>
</head>
<body>
	<%
	  String bNo = request.getParameter("boardNo");
		BoardDao dao =  new BoardDao();
		Board b = dao.getBoardInfo(Integer.parseInt(bNo));
		
		
	
	  out.print("<h1> Hello </h1>");
	  out.print("<h1> boardNo = " + bNo +  "</h1>");
	  //out.print("<a href=\"getBoardList.html\">List</a>");
	  
	%>
	<h1><a href = "getBoardList.html"> Board List </a></h1>
	<table border=1>
	<tr>
		<td>BoardNo</td>
		<td><%=bNo%></td>
	</tr>
	<tr>
		<td>Content</td>
		<td><%=b.getContent()%></td>
	</tr>
	<tr>
		<td>Writer</td>
		<td><%=b.getWriter()%></td>
	</tr>
	<tr>
		<td>CreateDate</td>
		<td><%=b.getDate()%></td>
	</tr>
	
		
	</table>

</body>
</html>