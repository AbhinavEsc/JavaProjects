package springcore.jdbc.dao;

import java.util.List;

import springcore.jdbc.model.Student;

public interface StudentDao {
	
	public int insert(Student student);
	
	public int update(Student student);
	
	public int delete(int id);
	
	public Student getStudent(int id);
	
	public List<Student> getAllStudent();
	

}
