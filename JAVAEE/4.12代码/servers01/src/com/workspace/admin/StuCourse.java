package com.workspace.admin;

public class StuCourse {

	public String stuname;
	public String stupassword;
	public StuCourse(String stuname, String stupassword) {
		super();
		this.stuname = stuname;
		this.stupassword = stupassword;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	
	
}
