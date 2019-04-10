package com.workspace.service;

import java.util.List;

import com.workspace.admin.Student;

public interface StudentInformation {

	public List<Student> addStudent(int id, String name, String sex, String age, String school, String address, String phone,
			String email, int score, String _date);
	
	public Student findStudentById(int id);
	
	public List<Student> findAll();
	
	public List<Student> updateStudent(int id, String text, String newtext , String _date);
	
	public List<Student> delStudent(int id);

}
