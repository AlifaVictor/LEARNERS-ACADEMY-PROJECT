package com.caltech.dbconfig;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;

import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



	


	

	/*  StandardServiceRegistry
	 * Metadata
	 * SessinFactory
	 * Transaction
	 * Close the connection
	 */
public class DbUtil {
	 StandardServiceRegistry ssr=null;
	 Metadata md=null;
	SessionFactory sf=null;
	Session session=null;
	Transaction tran=null;
	
	public  Session dbConn() {
		// to load the config file
		 ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//in the config file go to meta day level
		 md=new MetadataSources(ssr).getMetadataBuilder().build();
		// goto meta data of session factory
		 sf=md.getSessionFactoryBuilder().build();
		//to perform the crud operations
		 session=sf.openSession();
		return session;
		
		
		
	}

		
	}


