package com.caltech.pojo;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="Class")


public class Class {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Cid;
	private String Cname;
	
	//@OneToMany(cascade = CascadeType.ALL,mappedBy = "class")
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade = {CascadeType.ALL})
	 @JoinTable(
			 name = "Class_Subject", 
		      joinColumns = { @JoinColumn(name = "Cid") }, 
		      inverseJoinColumns = { @JoinColumn(name = "Sid") }
		  )
	 private Set<Subject> subject;
	  
	 // @OneToMany(cascade = CascadeType.ALL,mappedBy = "studentclass")
	  @LazyCollection(LazyCollectionOption.FALSE)
	  @ManyToMany(cascade = { CascadeType.ALL })
	  @JoinTable(
	      name = "Class_Teacher", 
	      joinColumns = { @JoinColumn(name = "Cid") }, 
	      inverseJoinColumns = { @JoinColumn(name = "Tid") }
	  ) 
	
	  private Set<Teacher> teacher;
	
	
	public Set<Subject> getSubject() {
		return subject;
	}
	public void setSubject(Set<Subject> subject) {
		this.subject = subject;
	}
	public Set<Teacher> getTeacher() {
		return teacher;
	}
	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	

}
