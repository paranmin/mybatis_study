package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;


public interface StudentDao {
	Student findStudentById(int studId);
	int insertStudent(Student student);
	int deleteStudent(int studId);
	List<Student> findAllStudents();
}
