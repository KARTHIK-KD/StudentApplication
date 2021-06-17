package com.onebill.service;

import com.onebill.bean.StudentBean;

public interface StudentService {
	public boolean studentAdd(double m1,double m2,double m3,StudentBean stud);
	public StudentBean searchStudent(int id);
	public boolean deleteStudent(int id);
	public StudentBean updateStudent(StudentBean stud);
	public double markStudent(int id);
	public String greadStudent(int id);

}
