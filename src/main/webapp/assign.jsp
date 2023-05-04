<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="com.caltech.Dao.TeacherDao"%>
<%@page import="com.caltech.pojo.Teacher"%>
<%@page import="com.caltech.Dao.StudentDao"%>
<%@page import="com.caltech.pojo.Student"%>
<%@page import="com.caltech.Dao.SubjectDao"%>
<%@page import="com.caltech.pojo.Subject"%>
<%@page import="com.caltech.Dao.ClassDao"%>
<%@page import="com.caltech.pojo.Class"%>
    <%@page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Subject and Teacher to Class</title>
</head>
<body>
<p>
<p>
<p>
<br>
<div align="center">
<h1>Assigning Subject and Teacher to Class <%=request.getParameter("CTE") %></h1>
<form action="assign2.jsp">
<table>
<tr>
<td>Subjects:</td><td><select name="subject">
<%
SubjectDao dao=new SubjectDao();
List<Subject> list= dao.display();
if (list!=null&& !list.isEmpty())
	for(Subject subject:list){
		%>
		<option value=<%=subject.getSid() %>><%=subject.getSname() %></option>
		<%} %></select></tr>
		<tr>
		<td>Teachers:</td><td><select name="teacher">
		<%TeacherDao dao1=new TeacherDao();
		List<Teacher>list1= dao1.display();
		if(list1!=null || !list1.isEmpty())
		for(Teacher teacher:list1){%>
		<option value="<%=teacher.getTid() %>"><%=teacher.getTname() %></option>
		<%} %></select>
		
		</tr>
		<tr><td colspan="1"><input type="submit" value ="Assign this subject and teacher" ></td></tr>
		<tr><td><input type="hidden" name="id" value=<%=request.getParameter("id") %>></td></tr>
		</table>
		</form>
		</div>
		</body>
		</html>
		