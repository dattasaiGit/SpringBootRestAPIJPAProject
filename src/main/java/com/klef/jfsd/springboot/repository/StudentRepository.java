package com.klef.jfsd.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>   // template< modelClassName, data type of primary key of model class>
{
	
}