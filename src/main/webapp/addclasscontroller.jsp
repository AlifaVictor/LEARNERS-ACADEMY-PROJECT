


<%@page import="com.caltech.pojo.Class"%>
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


ClassDao dao =new ClassDao();
Class class1=new Class();
class1.setCname(request.getParameter("cname"));


int row=dao.addclass(class1);
if (row>0){
	response.sendRedirect("indexclass2.jsp");
}
else{
	response.sendRedirect("fail.jsp");
	
}
%>
</body>
</html>