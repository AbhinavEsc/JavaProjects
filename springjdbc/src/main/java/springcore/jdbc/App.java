package springcore.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springcore.jdbc.dao.StudentDao;
import springcore.jdbc.model.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Started");
		// jdbc template object
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("springcore/jdbc/config.xml");

		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		StudentDao stud = context.getBean("studentDao", StudentDao.class);
		Student student = new Student();
		 student.setId(4);
		student.setName("Abhinav");
		 student.setAddress("Nagpur");

		 int result = stud.insert(student); //-->insert

		// int result = stud.update(student); --> update

		// int result = stud.delete(1223);
		// Student stude = stud.getStudent(1);
		// System.out.println(stude);

		List<Student> studes = stud.getAllStudent();
		for (Student stude : studes) {
			System.out.println(stude);
		}

	}
}
