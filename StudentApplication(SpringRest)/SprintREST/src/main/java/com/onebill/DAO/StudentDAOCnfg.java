package com.onebill.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.onebill.bean.StudentBean;

@Repository
public class StudentDAOCnfg implements StudentDAO {
	
//Insert process
	@Override
	public boolean studentDAOAdd(StudentBean stud) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(stud);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

//Search process
	@Override
	public StudentBean studentDAOSearch(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		StudentBean stud=em.find(StudentBean.class,id);
		try {
			if(stud!=null) {
				return stud;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//Delete process
	@Override
	public boolean deleteStudent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			StudentBean stud=em.find(StudentBean.class, id);
			em.remove(stud);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

//Update process
	@Override
	public StudentBean updateStudent(StudentBean stud) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			StudentBean student=em.find(StudentBean.class,stud.getUserid());
			if(stud.getEmail()!=null) {
				student.setName(student.getEmail());
			}
			em.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//Get Greade process
	@Override
	public String greadeStudent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		StudentBean stud=em.find(StudentBean.class,id);
		if(stud!=null) {
			return null;
		}
		else
		{
			return stud.getGrade();
		}
	}

//Get mark process
	@Override
	public double markStudent(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
		EntityManager em = emf.createEntityManager();
		StudentBean stud=em.find(StudentBean.class,id);
		return stud.getMark();
		
	}
}
