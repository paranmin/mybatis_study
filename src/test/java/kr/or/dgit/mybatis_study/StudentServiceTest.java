package kr.or.dgit.mybatis_study;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.service.StudentService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void test1CreateStudent() {
		Student student = new Student(1, "박초롱", "PartChorong@test.com", new Date());
		int res = studentService.createStudent(student);
		assertEquals(1, res);
	}
	
	@Test
	public void test2SearchStudentById() {
		Student student = studentService.searchStudentById(2);
		assertNotNull(student);
	}
	@Test
	public void test3selectStudentByAll() {
		List<Student> list = studentService.selectStudentByAll();
		assertNotNull(list);
	}
	@Test
	public void test4DeleteStudentById() {
		int res = studentService.deleteStudent(3);
		assertEquals(1, res);
	}

}
