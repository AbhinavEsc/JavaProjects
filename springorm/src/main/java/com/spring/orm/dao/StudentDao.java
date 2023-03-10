package com.spring.orm.dao;

import java.util.List;

import com.spring.orm.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	
	public Student getStudent(int id);

	public List<Student> getAllStudent();
	
	public void delete(int id);
	
	public void updateStudent(Student student);

}
