package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private HibernateTemplate hibernateTemplate;

	// save object
	@Transactional
	public int insert(Student student) {
		Integer result = (Integer) this.hibernateTemplate.save(student);
		return result;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public Student getStudent(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		return student;
	}

	
	public List<Student> getAllStudent() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void delete(int id) {
		Student student = this.hibernateTemplate.get(Student.class, id);
		this.hibernateTemplate.delete(student);
	}
	
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

}
