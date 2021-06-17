package com.onebill.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentBean {
	@Id
	private int Userid;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private double Mark;
	@Column
	private String Grade;
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public double getMark() {
		return Mark;
	}
	public void setMark(double mark) {
		Mark = mark;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "StudentBean [Userid=" + Userid + ", Name=" + Name + ", Email=" + Email + ", Mark=" + Mark + ", Grade="
				+ Grade + "]";
	}
	public StudentBean(int userid, String name, String email, double mark, String grade) {
		super();
		Userid = userid;
		Name = name;
		Email = email;
		Mark = mark;
		Grade = grade;
	}
	public StudentBean() {
		super();
	
	}
	
	
}

