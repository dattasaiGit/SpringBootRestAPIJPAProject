package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("student")
public class StudentController 
{
	@Autowired
	private StudentService service; // controller will access service layer.
	
	@GetMapping("/")
	public String home()
	{
		return "Spring Boot Rest API and JPA";
	}
	
	@PostMapping("add")
	public String addStudent(@RequestBody Student student)
	{
		return service.addStudent(student);
	}
	
	@GetMapping("viewall")
	public List<Student> viewallstudents()
	{
		return service.displayAllStudents();
	}
	
	@GetMapping("display")
	public Student displayStudent(@RequestParam("id") int sid)
	{
		return service.displayStudentById(sid);
	}
	
	@DeleteMapping("delete")
	public String deleteStudent(@RequestParam("id") int sid)
	{
		return service.deleteStudent(sid);
	}
	
	@PutMapping("update")
	public String updateStudent(@RequestBody Student s, HttpServletRequest request)
	{
		HttpSession session = request.getSession();       
		session.setAttribute("student",s);
		return service.updateStudent(s);
	}
	
	@GetMapping("count")
	public long countStudent()
	{
		return service.studentcount();
	}
}