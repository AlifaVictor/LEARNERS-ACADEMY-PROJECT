<%@page import="com.caltech.Dao.ClassDao"%>
<%@page import="com.caltech.pojo.Class"%>
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

<form action="addclass.jsp">
<input type="submit" value="addclass">
</form>

<h1>Class List</h1>
<table border="1">
<tr><th>ID</th><th>Class Name</th><th>Assign Subject and Teacher<th>Edit Action<th>Delete Action</th><th>View</th></tr>
<%

ClassDao dao=new ClassDao();

List<Class> list=dao.display();
for(Class c:list){
	%>
	<tr><td><%=c.getCid()%></td><td><%=c.getCname()%></td><td><a href="assign.jsp?">Assign Subject and teacher</a></td><td><a href="edit.jsp?id=<%=c.getCid()%>&category=class">Edit</a></td><td><a href="delete.jsp?id=<%=c.getCid()%>&category=class">Delete</a></td><td><a href="viewreport.jsp?id=<%=c.getCid()%>&classname<%=c.getCname()%>">View report</a></td></tr>
	<%} %>
</table>
</body>
</html>