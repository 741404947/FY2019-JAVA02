package com.workspace.userenum;

public enum UserEnum {

	LOGIN(1,"��½"),REGISTER(2,"ע��"),LOGIN_FAIL(3,"�˳���½"),PEO_ONLINE(4,"�鿴��������");
	private int choose_type;
	private String choose_desc;
	UserEnum(int choose_type, String choose_desc){
		this.choose_type = choose_type;
		this.choose_desc = choose_desc;
	}
	public int getChoose_type() {
		return choose_type;
	}
	public void setChoose_type(int choose_type) {
		this.choose_type = choose_type;
	}
	public String getChoose_desc() {
		return choose_desc;
	}
	public void setChoose_desc(String choose_desc) {
		this.choose_desc = choose_desc;
	}
	
}
