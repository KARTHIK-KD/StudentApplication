package com.onebill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ionebill.response.StudentResponse;
import com.onebill.bean.StudentBean;
import com.onebill.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	public StudentService service;
	
	
	//INSERT A STUDENTS DATA
	@PostMapping(path = "/addstudent/{mark1}/{mark2}/{mark3}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse addStudent(@PathVariable(name="mark1") double m1,@PathVariable(name ="mark2") double m2,@PathVariable(name ="mark2") double m3,@RequestBody StudentBean stud) {
		StudentResponse response=new StudentResponse();
		boolean bean=service.studentAdd(m1, m2, m3, stud);
		if(bean!=false) {
			
			response.setStatus(200);
			response.setMsg("Success");
			System.out.println("Data Inserted Successfully");	
		}
		else {
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Data Not Inserted ");	
		}
		return response;	
	}
	//SEARCH A STUDENT
	@GetMapping(path = "/searchStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse searchStudent(Integer id) {
		StudentResponse response=new StudentResponse();
		StudentBean stud=service.searchStudent(id);
		if(stud!=null) {
			response.setStatus(200);
			response.setMsg("Search");
			System.out.println(stud);
		}
		else
		{
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Data Not Inserted ");
		}	
		return response;	
	}
	
	//REMOVE A STUDENET
	@DeleteMapping(path = "/deleteStudent/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse deleteStudent(@PathVariable(name="id") int id) {
		StudentResponse response=new StudentResponse();
		if(service.deleteStudent(id)) {
			response.setStatus(200);
			response.setMsg("Delete");
			System.out.println("Successfully data is deleted");	
		}
		else {
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Data Not Deleted");	
		}
		return response;	
	}
	
	//UPDATE A STUDENT
	@PutMapping(path = "/updateStudent", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse updateStudent(@RequestBody StudentBean employeeInfo) {
		StudentResponse response=new StudentResponse();
		if(service.updateStudent(employeeInfo)!=null) {
			response.setStatus(200);
			response.setMsg("Update");
			System.out.println("Updated Successfully");	
		}
		else {
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Not Updated");	
		}
		return response;
	}
	
	//GET MARK
	@GetMapping(path = "/markStudent/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse markStudent(@RequestBody int id) {
		StudentResponse response=new StudentResponse();
		String greade=service.greadStudent(id);
		
		if(greade!=null) {
			response.setStatus(200);
			response.setMsg("Success");
			System.out.println("Your Greade is "+greade);	
		}
		else {
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Not Gread Present");	
		}
		return response;
		
	}

	
	//GET GREADE
	@GetMapping(path = "/greadeStudent/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public StudentResponse greadStudent(@RequestBody int id) {
		StudentResponse response=new StudentResponse();
		double mark=service.markStudent(id);
		
		if(mark>0) {
			response.setStatus(200);
			response.setMsg("Success");
			System.out.println("Your Mark is "+mark);	
		}
		else {
			response.setStatus(404);
			response.setMsg("Error");
			System.out.println("Not present in the mark");	
		}
		return response;
		
	}

	
}
