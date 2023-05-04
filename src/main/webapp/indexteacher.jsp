<%@page import="com.caltech.Dao.TeacherDao"%>
<%@page import="com.caltech.pojo.Teacher"%>
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

<form action="addteacher.jsp">
<input type="submit" value="addteacher">
</form>

<h1>Teacher List</h1>
<table border="1">
<tr><th>ID</th><th>Teacher Name</th><th>Teacher Designation</th><th>Edit Action<th>Delete Action</th></tr>
<%

TeacherDao dao=new TeacherDao();

List<Teacher> list=dao.display();
for(Teacher t:list){
	%>
	<tr><td><%=t.getTid()%></td><td><%=t.getTname()%></td><td><%=t.getTdesignation() %></td><td><a href="edit.jsp?id=<%=t.getTid()%>&category=teacher">Edit</a></td><td><a href="delete.jsp?id=<%=t.getTid()%>&category=teacher">Delete</a></td></tr>
	<%} %>
</table>
</body>
</html>