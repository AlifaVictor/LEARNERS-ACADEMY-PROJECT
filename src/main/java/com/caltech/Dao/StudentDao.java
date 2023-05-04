package com.caltech.Dao;





import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.caltech.dbconfig.DbUtil;
import com.caltech.pojo.Student;

public class StudentDao {
	public int addstudent(Student student) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Student newstudent=new Student();
		newstudent.setSfirstname(student.getSfirstname());
		newstudent.setSlastname(student.getSlastname());
		newstudent.setSaddress(student.getSaddress());
	    newstudent.setSphone(student.getSphone());
		newstudent.setDate(student.getDate());
		int value=(Integer) 
		session.save(newstudent);		
		trans.commit();
		session.close();
		return value;
	}
	public List<Student> display(){
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Student");
		List<Student> list =query.list();
		trans.commit();
		session.close();
		return list;
		
	}
	public int deleteStudent(int id) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("delete from Student where id="+id);
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;
	}
	
	public  int edit(Student student) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("update Student student set Sfirstname='"+student.getSfirstname()+"', Slastname='"+student.getSlastname()+"',Saddress= '"+student.getSaddress()+"'where id="+student.getSid());
		//query.setString(1,student.getSfirstname());
		//query.setString(2,student.getSlastname());
		//query.setString(3,student.getSaddress());
		//query.setInteger(4,student.getSid());
		
		
		int value=(Integer) 
				
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;

}
	public List<Student> getReport(int Cid)
	{
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Student where Cid="+ Cid);
		List<Student> list = query.getResultList();
		trans.commit();
		session.close();
		return list;
	}

}


