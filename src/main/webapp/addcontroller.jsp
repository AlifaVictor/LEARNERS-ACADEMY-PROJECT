
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.caltech.pojo.Student"%>
<%@page import="com.caltech.Dao.StudentDao"%>
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


StudentDao dao =new StudentDao();
Student student=new Student();

student.setSfirstname(request.getParameter("sfirstname"));
student.setSlastname(request.getParameter("slastname"));
student.setSaddress(request.getParameter("saddress"));
student.setSphone(Float.parseFloat(request.getParameter("sphone")));

String sdate=request.getParameter("sdob");
//System.out.println(sdate);
//convert string into a java date format[yyy-mmm-ddd] mysql db dateformat
SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");
Date date=dateformat.parse(sdate);
student.setDate(date);
int row=dao.addstudent(student);
if (row>0){
	response.sendRedirect("success.jsp");
}
else{
	response.sendRedirect("fail.jsp");
	
}
%>
</body>
</html>