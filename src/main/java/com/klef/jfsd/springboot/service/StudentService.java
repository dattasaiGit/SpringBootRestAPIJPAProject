package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Student;


public interface StudentService 
{
	public String addStudent(Student s);
	public String updateStudent(Student s);
	public String deleteStudent(int sid);
	public List<Student> displayAllStudents();
	public Student displayStudentById(int sid);
	public Long studentcount();
}