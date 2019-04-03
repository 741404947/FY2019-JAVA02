package com.StudentSystem.User;

public class Student implements Comparable<Student> {
	public  String _date;
	public int id;
	public String name;
	public String sex;
	public int age;
	public String school;
	public String address;
	public String phone;
	public String email;
	public int score;
	
	
	public Student() {
		
	}
	
	public Student(int id, String name, String sex, int age, String school, String address, String phone,
			String email, int score, String _date) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.school = school;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this._date = _date;
		this.score = score;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int compareTo(Student arg0) {
		// TODO Auto-generated method stub
		return this.score-arg0.score;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String get_date() {
		return _date;
	}


	public void set_date(String _date) {
		this._date = _date;
	}


	
	
}
