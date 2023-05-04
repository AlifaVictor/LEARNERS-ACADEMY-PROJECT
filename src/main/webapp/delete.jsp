
<%@page import="com.caltech.Dao.TeacherDao"%>
<%@page import="com.caltech.Dao.StudentDao"%>
<%@page import="com.caltech.Dao.SubjectDao"%>
<%@page import="com.caltech.Dao.ClassDao"%>
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
<%
out.println(request.getParameter("category"));
switch(request.getParameter("category")){
case"teacher":TeacherDao tdao=new TeacherDao();
int res=tdao.deleteTeacher(Integer.parseInt(request.getParameter("id")));
out.println("Deleted succesfully");
response.sendRedirect("indexteacher.jsp");
break;
case"subject": SubjectDao sdao=new SubjectDao();
int res1=sdao.deleteSubject(Integer.parseInt("id"));
out.println("Deleted successfully");
if(res1>0)response.sendRedirect("subjectindex.jsp");
else response.sendRedirect("index.jsp");
break;
case"class":ClassDao cdao=new ClassDao();
int res2=cdao.deleteClass(Integer.parseInt(request.getParameter("id")));
out.println("Deleted succesfully");
if(res2>0)response.sendRedirect("indexclass.jsp");
else response.sendRedirect("index.jsp");
break;
case "student":StudentDao stdao=new StudentDao();
int res3=stdao.deleteStudent(Integer.parseInt(request.getParameter("id")));
out.println("Deleted successfully");
if(res3>0)response.sendRedirect("index.jsp");
else response.sendRedirect("success.jsp");
break;
default:
	out.println("wrong selection");
}
%>
</body>
</html>
