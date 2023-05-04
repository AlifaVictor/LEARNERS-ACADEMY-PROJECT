package com.caltech.Dao;



import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.caltech.dbconfig.DbUtil;
import com.caltech.pojo.Student;
import com.caltech.pojo.Subject;

public class SubjectDao {


	public int addsubject(Subject subject) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Subject newsubject=new Subject();
		newsubject.setSname(subject.getSname());
		int value=(Integer) 
		session.save(newsubject);		
		trans.commit();
		session.close();
		return value;
	}
	public List<Subject> display(){
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Subject");
		List<Subject> list =query.list();
		trans.commit();
		session.close();
		return list;
		
	}
	public int deleteSubject(int Sid) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("delete from Subject where Sid="+Sid);
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;
	}
	public int edit(Subject subject) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("Update Subject set Sname='"+subject.getSname()+"'where Sid="+subject.getSid());
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;


}
	public Subject getEntity(int Sid)
	{
		DbUtil dbconn = new DbUtil();
		Session session = dbconn.dbConn();
		Transaction trans = session.beginTransaction();
		Query query=session.createQuery("from Subject where Sid=" + Sid);
		Subject subject = (Subject)query.getSingleResult();
		trans.commit();
		 session.close();
		return subject;
	}
	
	
}
 
	


	
	
	
	


