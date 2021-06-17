package com.onebill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onebill.DAO.StudentDAO;
import com.onebill.bean.StudentBean;

@Service
public class StudenrtServiceCnfg implements StudentService{
	
	@Autowired
	StudentDAO dao;
	
	//ADD Student
	@Override
	public boolean studentAdd(double m1,double m2,double m3,StudentBean stud) {
		double mark=((m1+m2+m3)/3)/10;
		stud.setMark(mark);
		
		if(stud.getMark()>=9.1 && stud.getMark()<=10) {
			stud.setGrade("A+");
		}
		else if(stud.getMark()>=8.1 && stud.getMark()<9.0) {
			stud.setGrade("A");
		}
		else if(stud.getMark()>=7.1 && stud.getMark()<8.0) {
			stud.setGrade("B+");
		}
		else if(stud.getMark()>=6.1 && stud.getMark()<7.0) {
			stud.setGrade("C");
		}
		else if(stud.getMark()>=5.1 && stud.getMark()<6.0) {
			stud.setGrade("D");
		}
		else if(stud.getMark()>=4.1 && stud.getMark()<5.0) {
			stud.setGrade("E");
		}
		else if(stud.getMark()<=4.0) {
			stud.setGrade("F");
		}
		return dao.studentDAOAdd(stud);		
	}
	
	//Search Student details
	@Override
	public StudentBean searchStudent(int id) {
		if(id<0) {
			return null;
		}
		return dao.studentDAOSearch(id);
	}
	
	//delete one Record
	@Override
	public boolean deleteStudent(int id) {
		return dao.deleteStudent(id);
	}
	
	//update Student details
	@Override
	public StudentBean updateStudent(StudentBean stud) {
		return null;
	}
	
	//Get Student greade pont
	@Override
	public String greadStudent(int id) {
		if(id<0) {
			return null;
		}
		return dao.greadeStudent(id);
	}
	
	//Get Student mark
	@Override
	public double markStudent(int id) {
		if(id<0) {
			return 0;
		}
		return dao.markStudent(id);
	}
	
	

}
