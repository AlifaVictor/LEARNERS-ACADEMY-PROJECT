package com.caltech.pojo;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Sid;
private String Sname;
@ManyToMany(mappedBy = "subject",fetch = FetchType.EAGER)
private  Set<Class> class1;
public Set<Class> getClass1() {
	return class1;
}
public void setClass1(Set<Class> class1) {
	this.class1 = class1;
}
public int getSid() {
	return Sid;
}
public void setSid(int sid) {
	Sid = sid;
}
public String getSname() {
	return Sname;
}
public void setSname(String sname) {
	Sname = sname;
}

}
