
<%@page import="com.caltech.Dao.SubjectDao"%>
<%@page import="com.caltech.pojo.Subject"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="./Class">class</a>
<a href="./Student">student</a>
<a href="./Subject">subject</a>
<a href="./Teacher">teacher</a>
<a href="./Logout">logout</a>

<form action="addsubject.jsp">
<input type="submit" value="addsubject">
</form>

<h1>Subject List</h1>
<table border="1">
<tr><th>ID</th><th>Subject Name</th><th>Edit Action<th>Delete Action</th></tr>
<%

SubjectDao dao=new SubjectDao();

List<Subject> list=dao.display();
for(Subject s:list){
	%>
	<tr><td><%=s.getSid()%></td><td><%=s.getSname()%></td><td><a href="edit.jsp?id=<%=s.getSid()%>&category=subject">Edit</a></td><td><a href="delete.jsp?id=<%=s.getSid()%>&category=subject">Delete</a></td></tr>
	<%} %>
</table>
</body>
</html>