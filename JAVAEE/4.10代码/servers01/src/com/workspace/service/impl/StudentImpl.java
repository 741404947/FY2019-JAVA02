package com.workspace.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.workspace.admin.Admin;
import com.workspace.admin.Student;
import com.workspace.service.StudentInformation;

public class StudentImpl implements StudentInformation {

	private static StudentImpl si;
	
	 static List<Student> stu = new ArrayList<Student>();

	private StudentImpl() {
		// TODO Auto-generated constructor stub
		
		Student student = new Student(1 , "huqisheng", "nv", "12", "chuzhong", "riben", "250", "250@250", 59, "19-4-1 10:55:05");
		Student student2 = new Student(2 , "xuwenjie", "nv", "21", "gaozhong", "meiguo", "25", "25@25", 10, "19-4-5 11:55:05");
		stu.add(student);
		stu.add(student2);
	}
	
	public synchronized static StudentImpl getInstance() {
		 if(si == null) {
			 si = new StudentImpl();
		 }
		return si;
		
	}
	
	@Override
	public List<Student> addStudent(int id, String name, String sex, String age, String school, String address, String phone,
			String email, int score, String _date) {
		// TODO Auto-generated method stub

		boolean isid = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isid = false;
				break;
			}
		}
		for (int i = 0; i < stu.size(); i++) {
			Student student3= new Student(id, name, sex, age, school , address , phone , email ,score , _date);
			stu.add(student3);
			break;
		}
		return stu;
	}
	
	public boolean isid(int id){
		// TODO Auto-generated method stub
		boolean isid = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isid = false;

			}
		}
		return true;
	}

	@Override
	public Student findStudentById(int i) {
		// TODO Auto-generated method stub
		System.out.println(stu.get(i).getId() + "|" + "\t" + stu.get(i).getName() + "|" + "\t" + "\t" + stu.get(i).getSex() + "|" + "\t" 
				+ stu.get(i).getAge() + "|" + "\t" + stu.get(i).getSchool() + "|" + "\t" 
				+ stu.get(i).getAddress() + "|" + "\t" + stu.get(i).getPhone() + "|" + "\t" 
				+ stu.get(i).getEmail() + "|" + "\t" + stu.get(i).getScore() + "|" + "\t" +stu.get(i).get_date());
		return stu.get(i);
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				break;
			}
			System.out.println(stu.get(i).getId() + "|" + "\t" + stu.get(i).getName() + "|" + "\t" + "\t" + stu.get(i).getSex() + "|" + "\t" 
										+ stu.get(i).getAge() + "|" + "\t" + stu.get(i).getSchool() + "|" + "\t" 
										+ stu.get(i).getAddress() + "|" + "\t" + stu.get(i).getPhone() + "|" + "\t" 
										+ stu.get(i).getEmail() + "|" + "\t" + stu.get(i).getScore() + "|" + "\t" +stu.get(i).get_date());
		}
		return stu;
	}

	@Override
	public List<Student> updateStudent(int id, String text, String newtext , String _date) {
		// TODO Auto-generated method stub

		boolean isidexit = true;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isidexit = false;
				if(text.equals("name")) {
					stu.get(i).setName(newtext); 
				}else if(text.equals("sex")) {
					stu.get(i).setSex(newtext);
				}else if(text.equals("school")) {
					stu.get(i).setSchool(newtext);
				}else if(text.equals("address")) {
					stu.get(i).setAddress(newtext);
				}else if(text.equals("phone")) {
					stu.get(i).setPhone(newtext);
				}else if(text.equals("email")) {
					stu.get(i).setEmail(newtext);
				}
			}
			stu.get(i).set_date(_date);
		}
		return stu;
	}
	public boolean update_id(int id) {
		boolean isidexit = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Student> delStudent(int id) {
		// TODO Auto-generated method stub

		boolean isdel = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				isdel = true;
				stu.remove(i);
			}
			//System.out.println(stu[i]);
		}
		return stu;
	}
	public boolean del_isid(int id) {
		boolean isdel = false;
		for (int i = 0; i < stu.size(); i++) {
			if(stu == null) {
				continue;
			}
			if(stu.get(i).getId() == id) {
				return true;
			}
		}
		
		return false;
	}

}
