package com.workspace.userenum;

public enum StudentEnum {

	STU_LOGIN(1,"学生登陆"),STU_XUAN_COURSE(2,"选择课程"),STU_SHAN_COURSE(3,"删除课程"),
	STU_FIN_COURSE(4,"查看已经选的课程");
	private int stu_type;
	private String stu_desc;
	private StudentEnum(int stu_type, String stu_desc) {
		this.stu_type = stu_type;
		this.stu_desc = stu_desc;
	}
	public int getStu_type() {
		return stu_type;
	}
	public void setStu_type(int stu_type) {
		this.stu_type = stu_type;
	}
	public String getStu_desc() {
		return stu_desc;
	}
	public void setStu_desc(String stu_desc) {
		this.stu_desc = stu_desc;
	}
	
}
