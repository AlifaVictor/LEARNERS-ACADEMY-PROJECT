package com.caltech.Dao;


import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.caltech.dbconfig.DbUtil;
import com.caltech.pojo.Class;
import com.caltech.pojo.Report;
import com.caltech.pojo.Student;
import com.caltech.pojo.Subject;
import com.caltech.pojo.Teacher;

public class ClassDao {


	public int addclass(Class class1) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Class newclass=new Class();
		
		newclass.setCname(class1.getCname());
		
		int value=(Integer) session.save(newclass);		
		trans.commit();
		session.close();
		return value;
	}
	public List<Class> display(){
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Class");
		List<Class> list =query.list();
		trans.commit();
		session.close();
		return list;
		
	}
	public int deleteClass(int id) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("delete from Class where id="+id);
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;
	}
	public int edit(Class class1) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("Update Class class1 set Cname='"+class1.getCname()+"'where Cid="+class1.getCid());
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;
}
	public List<Report> getReport1(int Cid)
	{
		List<Report> results = new ArrayList();
		
		Class class1 = getEntity(Cid);
		if(class1!=null && class1.getTeacher()!= null && class1.getSubject() !=null) 
		{
			for(Teacher teacher: class1.getTeacher())
			{
				Report r = new Report();
				r.setClassname(class1.getCname());
				r.setTdesignation(teacher.getTdesignation());
				r.setTeachername(teacher.getTname());
				results.add(r);
				
			}
		}
		
		return results;
	}
	public int insert(String Classname) throws ClassNotFoundException, SQLException
	{
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();	
	   Class class1 = new Class();
		class1.setCname("CTE");		
		class1.setSubject(null);
		class1.setTeacher(null);
		
		int value=(Integer) session.save(class1);
		trans.commit();
		session.close();
		return value;
	}
	public int setteacherSubject(int Cid, int Tid, int Sid)
	 {
		    SubjectDao sdao = new SubjectDao();
			TeacherDao tdao = new TeacherDao();
		    Class class1 = getEntity(2);
			Subject subject =  sdao.getEntity(1);
			Teacher teacher =  tdao.getEntity(1);
			if(class1!= null && class1.getSubject() !=null && !class1.getSubject().contains(subject))
			{
		    class1.getSubject().add(subject);
			}
			if(class1!= null && class1.getTeacher() !=null && !class1.getTeacher().contains(teacher))
			{
		    class1.getTeacher().add(teacher);
			}
			
		    DbUtil dbconn=new DbUtil();
		    
			Session session=dbconn.dbConn();
			Transaction trans=session.beginTransaction();			
			
			ArrayList<Subject> slist = new ArrayList<>();
			ArrayList<Teacher> tlist = new ArrayList<>();
			slist.add(subject);
			tlist.add(teacher);
			session.merge(class1);
			 trans.commit();
			 session.close();	
			
			return 1;
	 }
	 public Class getEntity(int Cid)
		{
			DbUtil dbconn = new DbUtil();
			Session session = dbconn.dbConn();
			Transaction trans = session.beginTransaction();
			Query query=session.createQuery("from Class where Cid=" + Cid);
			Class class1 = (Class)query.getSingleResult();
			trans.commit();
			session.close();
			return class1;
	}}


