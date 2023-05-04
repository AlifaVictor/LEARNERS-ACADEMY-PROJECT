package com.caltech.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Sid;
private String Sfirstname;
private String Slastname;
private String Saddress;
private float Sphone;
@Temporal(TemporalType.DATE)
private Date date;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "Cid")
private Class class1;

public Class getClass1() {
	return class1;
}
public void setClass1(Class class1) {
	this.class1 = class1;
}
public int getSid() {
	return Sid;
}
public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
public void setSid(int sid) {
	Sid = sid;
}
public String getSfirstname() {
	return Sfirstname;
}
public void setSfirstname(String sfirstname) {
	Sfirstname = sfirstname;
}
public String getSlastname() {
	return Slastname;
}
public void setSlastname(String slastname) {
	Slastname = slastname;
}
public String getSaddress() {
	return Saddress;
}
public void setSaddress(String saddress) {
	Saddress = saddress;
}
public float getSphone() {
	return Sphone;
}
public void setSphone(float sphone) {
	Sphone = sphone;
}
 
}



