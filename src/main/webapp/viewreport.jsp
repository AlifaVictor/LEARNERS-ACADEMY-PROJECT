<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.caltech.Dao.ClassDao" %>
<%@ page import="com.caltech.pojo.Class" %>

<%@ page import="com.caltech.Dao.StudentDao" %>
<%@ page import="java.util.List" %>  
<%@ page import="com.caltech.pojo.Report" %>
<%@ page import="com.caltech.pojo.Student" %> 
<%@ page import="com.caltech.pojo.Teacher" %>
<%@ page import="com.caltech.Dao.TeacherDao" %> 
<%@ page import="com.caltech.pojo.Subject" %>
<%@ page import="com.caltech.Dao.SubjectDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner Academy - Display Reports</title>
</head>
<body>
<p>
<p>
<p>
<br>
<br>
<div align="center">
<h1>View Teacher and subjects of <%=request.getParameter("CTE") %></h1>
<table border=1>
<tr><th>Class name</th><th>Subject</th><th> Teacher</th></tr>
<%
ClassDao cdao = new ClassDao();
List<Report> res =   cdao.getReport1(Integer.parseInt( request.getParameter("id")));
for(Report r: res)
{
%><tr><td><%=r.getClassname() %></td><td><%=r.getTdesignation() %></td><td><%=r.getTeachername() %></td></tr>
<%} %>
</table>
<h1>View all students of <%=request.getParameter("Cname") %></h1>
<table border=1>
<tr><th>Class name</th><th>Student First Name</th><th>Student Last Name</th><tr>
<%
StudentDao	 sdao = new StudentDao();
List<Student> res1 = sdao.getReport(Integer.parseInt(request.getParameter("id")));
for(Student s:res1){
%>
<tr><td><%=request.getParameter("Cname") %></td><td><%=s.getSfirstname() %></td><td><%=s.getSlastname() %></td></tr>
<%} %>
</table>
</div>
</body>
</html>