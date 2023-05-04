package com.caltech.Dao;



import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.caltech.dbconfig.DbUtil;
import com.caltech.pojo.Student;
import com.caltech.pojo.Teacher;

public class TeacherDao {


	public int addteacher(Teacher teacher) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Teacher newteacher=new Teacher();
		newteacher.setTname(teacher.getTname());
		newteacher.setTdesignation(teacher.getTdesignation());
		int value=(Integer) 
		session.save(newteacher);		
		trans.commit();
		session.close();
		return value;
	}
	public List<Teacher> display(){
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("from Teacher");
		List<Teacher> list =query.list();
		trans.commit();
		session.close();
		return list;
		
	}
	public int deleteTeacher(int id) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("delete from Teacher where Tid="+id);
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;
	}
	public int edit(Teacher teacher) {
		DbUtil dbconn=new DbUtil();
		Session session=dbconn.dbConn();
		Transaction trans=session.beginTransaction();
		Query query=session.createQuery("update Teacher teacher set Tname='"+teacher.getTname()+"', Tdesignation='"+teacher.getTdesignation()+"'where id="+teacher.getTid());
		
		int value=(Integer) 
				query.executeUpdate();	
				trans.commit();
				session.close();
				return value;


}
	public Teacher getEntity(int Tid)
	{
		DbUtil dbconn = new DbUtil();
		Session session = dbconn.dbConn();
		Transaction trans = session.beginTransaction();
		Query query=session.createQuery("from Teacher where Tid=" + Tid);
		Teacher teacher = (Teacher)query.getSingleResult();
		trans.commit();
		session.close();
		return teacher;
	}
	
}
 
		


