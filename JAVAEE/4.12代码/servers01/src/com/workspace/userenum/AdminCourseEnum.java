package com.workspace.userenum;

public enum AdminCourseEnum {

	ADD_COURSE(1,"����γ�"),FX_COURSE(2,"�޸Ŀγ�"),DEL_COURSE(3,"ɾ���γ�"),
	FIND_COURSE(4,"�鿴�γ�");
	private int course_type;
	private String course_desc;
	 AdminCourseEnum(int course_type, String course_desc) {
		this.course_type = course_type;
		this.course_desc = course_desc;
	}
	public int getCourse_type() {
		return course_type;
	}
	public void setCourse_type(int course_type) {
		this.course_type = course_type;
	}
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	
	
}
