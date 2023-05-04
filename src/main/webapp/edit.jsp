
<%@page import="com.caltech.Dao.TeacherDao"%>
<%@page import="com.caltech.pojo.Teacher"%>
<%@page import="com.caltech.Dao.StudentDao"%>
<%@page import="com.caltech.pojo.Student"%>
<%@page import="com.caltech.Dao.SubjectDao"%>
<%@page import="com.caltech.pojo.Subject"%>
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
<%
switch(request.getParameter("category")){
case "student":
	StudentDao sdao=new StudentDao();
	Student student=new Student();
	student.setSid(Integer.parseInt(request.getParameter("id")));
	student.setSfirstname("john");
	student.setSlastname("Alifa");
	student.setSaddress("Newyork");
	
	int row=sdao.edit(student);
	if(row>0){
		response.sendRedirect("index.jsp");
	}
	else{
		response.sendRedirect("fail.jsp");
	}
	break;
case"teacher":
	TeacherDao tdao=new TeacherDao();
	Teacher teacher=new Teacher();
	teacher.setTname("Aminat muhd");
	teacher.setTdesignation("Zoology");
	teacher.setTid(Integer.parseInt(request.getParameter("id")));
	int res1=tdao.edit(teacher);
	out.println("Teacher edited");
	response.sendRedirect("indexteacher.jsp");
	break;
case "subject":
	SubjectDao sbdao=new SubjectDao();
	Subject subject=new Subject();
	subject.setSname("Social studies");
	subject.setSid(Integer.parseInt(request.getParameter("id")));
	int res2=sbdao.edit(subject);
	out.println("Subject edited");
	response.sendRedirect("subjectindex.jsp");
	break;
case "class":
	ClassDao cdao=new ClassDao();
    Class class1=new Class();
    class1.setCname("CTE");
    class1.setCid(Integer.parseInt(request.getParameter("id")));
    int res3=cdao.edit(class1);
    out.println("Class edited");
    response.sendRedirect("indexclass.jsp");
    break;
    default:
    	out.println("wrong selection");
    

}
%>
</body>
</html>