package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentRepository repository;  // service layer access repository layer.
	
	@Override
	public String addStudent(Student s) 
	{
		repository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public String updateStudent(Student s) 
	{
		Optional<Student> obj = repository.findById(s.getId());
		String msg=null;
		
		if(obj.isPresent())
		{
			Student student = obj.get();
			// update operation
			student.setName(s.getName());
			student.setAge(s.getAge());
			student.setGender(s.getGender());
			student.setEmail(s.getEmail());
			student.setDepartment(s.getDepartment());
			student.setContact(s.getContact());
			
			repository.save(student);
			msg="Student Updated Successfully";
			
		}
		else
		{
			msg="Student ID Not Found";
		}
		
		return msg;
	}

	@Override
	public String deleteStudent(int sid) 
	{
		Optional<Student> obj = repository.findById(sid);
		String msg=null;
		
		if(obj.isPresent())
		{
			Student s = obj.get(); // retrives student object by get method
			repository.delete(s);
			msg = "Student Deleted Successfully";
		}
		else
		{
			msg = "Student ID Not Found";
		}
		return msg;
	}
	
	@Override
	public List<Student> displayAllStudents()
	{
	    return (List<Student>) repository.findAll();
	}
	
	@Override
	public Student displayStudentById(int sid) 
	{
		return repository.findById(sid).get();  // findById will return optional class but .get() method will return student object
	}
	
	@Override
	public Long studentcount() 
	{
		return repository.count();
	}
}
