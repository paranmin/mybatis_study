package kr.or.dgit.mybatis_study.dao;

import java.util.List;

import kr.or.dgit.mybatis_study.dto.Student;


public interface StudentDao {
	Student findStudentById(int studId);
	void insertStudent(Student student);
	void deleteStudent(int studId);
	List<Student> findAllStudents();
}
