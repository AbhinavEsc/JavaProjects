package springcore.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import springcore.jdbc.dao.StudentDao;
import springcore.jdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages = { "springcore.jdbc.dao" })
public class JavaConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Abhinav@1999");
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;

	}
	
	
	List<Object> employee = new ArrayList<Object>();
List<Object> value = employee.stream().filter(e->e.salary>5000).collect(Collectors.toList())

	/*
	 * @Bean("studentDao") public StudentDaoImpl getStudentDaoImpl() {
	 * StudentDaoImpl studentdao = new StudentDaoImpl();
	 * studentdao.setJdbcTemplate(getTemplate()); return studentdao; }
	 */
}
