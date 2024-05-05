package com.student.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.student.restapi.entity.Student;
import com.student.restapi.repository.StudentRepository;




@RestController
public class StudentController 
{
	@Autowired
	StudentRepository studentRepository;
	
	//Get All the Student
	//localhost:8080/students
	@GetMapping("/students")
  public List<Student> getAllStudents()
  {
		
		 List<Student> stuList = studentRepository.findAll();
	  return stuList;
  }
	
	
	//localhost:8080/students/1
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) 
	{
		Student student = studentRepository.findById(id).get();
		return student;
	}
	
	
	//localhost:8080/create/student
	
	@PostMapping("/create/student")
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student)
	{
		studentRepository.save(student);
	}
	
	//localhost:8080/studentmanagement/update/student/3
	@PutMapping("/update/student/{id}")
	public Student updateStudent(@PathVariable int id) 
	{
	Student	student=studentRepository.findById(id).get();
	student.setName("Rajesh");
	student.setPercentage(91.00f);
	student.setBranch("B.Pharma");
	studentRepository.save(student);
		
		return student;
	}

	
	//localhost:8080/studentmanagement/delete/student/4
	@DeleteMapping("/delete/student/{id}")
	public Student deleteStudent(@PathVariable int id) 
	{
		 Student student = studentRepository.findById(id).get();
		 studentRepository.delete(student);
		return student;
	}
}
