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
@Table(name="Teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Tid;
private String Tname;
private String Tdesignation;
@ManyToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
private Set<Class> class1;
public Set<Class> getClass1() {
	return class1;
}
public void setClass1(Set<Class> class1) {
	this.class1 = class1;
}
public int getTid() {
	return Tid;
}
public void setTid(int tid) {
	Tid = tid;
}
public String getTname() {
	return Tname;
}
public void setTname(String tname) {
	Tname = tname;
}
public String getTdesignation() {
	return Tdesignation;
}
public void setTdesignation(String tdesignation) {
	Tdesignation = tdesignation;
}


}
