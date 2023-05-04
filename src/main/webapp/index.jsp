<%@page import="com.caltech.Dao.StudentDao"%>
<%@page import="com.caltech.pojo.Student"%>
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

<form action="addstudent.jsp">
<input type="submit" value="addstudent">
</form>

<h1>Student List</h1>
<table border="1">
<tr><th>ID</th><th>First Name</th><th>Last Name</th><th>Address</th><th>Phone</th><th>DOB</th><th>Edit Action<th>Delete Action</th></tr>
<%

StudentDao dao=new StudentDao();

List<Student> list=dao.display();
for(Student s:list){
	%>
	<tr><td><%=s.getSid()%></td><td><%=s.getSfirstname()%></td><td><%=s.getSlastname() %></td><td><%=s.getSaddress() %></td><td><%=s.getSphone() %></td><td><%=s.getDate() %></td><td><a href="edit.jsp?id=<%=s.getSid()%>&category=student">Edit</a></td><td><a href="delete.jsp?id=<%=s.getSid()%>&category=student">Delete</a></td></tr>
	<%} %>   
</table>
</body>
</html>