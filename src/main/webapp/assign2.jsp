<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.caltech.pojo.Class" %>
<%@ page import="com.caltech.Dao.ClassDao" %>
<%@ page import="com.caltech.pojo.Teacher" %>
<%@ page import="com.caltech.Dao.TeacherDao" %>
<%@ page import="com.caltech.pojo.Subject" %>
<%@ page import="com.caltech.Dao.SubjectDao" %>
<%@ page import="java.util.List" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ClassDao class1 = new ClassDao();
int ret = class1.setteacherSubject(1, 1, 1);
if(ret >0)
	response.sendRedirect("success4.jsp");
else
	response.sendRedirect("Index.jsp");
%>
</body>
</html>