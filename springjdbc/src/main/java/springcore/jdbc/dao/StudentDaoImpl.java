package springcore.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springcore.jdbc.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		int result = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getAddress());

		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int update(Student student) {

		String query = "update student set name=?, city=? where id=?";
		int res = this.jdbcTemplate.update(query, student.getName(), student.getAddress(), student.getId());

		return res;
	}

	public int delete(int id) {
		String query = "delete from student where id=?";
		int res = this.jdbcTemplate.update(query, id);
		return res;
	}

	public Student getStudent(int id) {
		// Select single data;
		RowMapper<Student> rowMapper = new RowMapperImpl();
		String query = "select * from student where id = ?";
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, id);

		return student;
	}

	public List<Student> getAllStudent() {
		String query = "select * from student";
		List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl());

		return students;
	}

}
