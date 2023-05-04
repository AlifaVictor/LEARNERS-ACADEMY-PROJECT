

<%@page import="com.caltech.pojo.Teacher"%>
<%@page import="com.caltech.Dao.TeacherDao"%>
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


TeacherDao dao =new TeacherDao();
Teacher teacher=new Teacher();

teacher.setTname(request.getParameter("tname"));
teacher.setTdesignation(request.getParameter("tdesignation"));

int row=dao.addteacher(teacher);
if (row>0){
	response.sendRedirect("success2.jsp");
}
else{
	response.sendRedirect("fail2.jsp");
	
}
%>
</body>
</html>