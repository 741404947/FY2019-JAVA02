package com.workspace.userenum;

public enum StudentEnum {

	STU_LOGIN(1,"ѧ����½"),STU_XUAN_COURSE(2,"ѡ��γ�"),STU_SHAN_COURSE(3,"ɾ���γ�"),
	STU_FIN_COURSE(4,"�鿴�Ѿ�ѡ�Ŀγ�");
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
