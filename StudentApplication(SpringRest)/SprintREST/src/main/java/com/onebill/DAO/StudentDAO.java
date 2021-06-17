package com.onebill.DAO;

import com.onebill.bean.StudentBean;

public interface StudentDAO {
	public boolean studentDAOAdd(StudentBean stud);
	public StudentBean studentDAOSearch(int id);
	public boolean deleteStudent(int id);
	public StudentBean updateStudent(StudentBean stud);
	public double markStudent(int id);
	public String greadeStudent(int id);
}
