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
<a href="assign.jsp">assign</a>
<a href="indexclass2.jsp">classreport</a>
<a href="./Logout">logout</a>

<form action="addclass.jsp">
<input type="submit" value="addclass">
</form>

<h1>Class List</h1>
<table border="1">
<tr><th>ID</th><th>Class Name</th><th>Edit Action<th>Delete Action</th></tr>
<%

ClassDao dao=new ClassDao();

List<Class> list=dao.display();
for(Class c:list){
	%>
	<tr><td><%=c.getCid()%></td><td><%=c.getCname()%></td><td><a href="edit.jsp?id=<%=c.getCid()%>&category=class">Edit</a></td><td><a href="delete.jsp?id=<%=c.getCid()%>&category=class">Delete</a></td></tr>
	<%} %>
</table>
</body>
</html>