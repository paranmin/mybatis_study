package kr.or.dgit.mybatis_study.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_study.dao.StudentDao;
import kr.or.dgit.mybatis_study.dto.Student;
import kr.or.dgit.mybatis_study.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}
	
	private StudentService() {}
	
	public int createStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			int res = studentDao.insertStudent(student);
			return res;
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public Student searchStudentById(int studId) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.findStudentById(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Student> selectStudentByAll() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public int deleteStudent(int studId) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
			return studentDao.deleteStudent(studId);
		} finally {
			sqlSession.close();
		}
	}
}
