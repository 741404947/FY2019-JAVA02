package com.workspace.userenum;

public enum UserEnum {

	LOGIN(1,"��½"),REGISTER(2,"ע��");
	private int nameenum;
	private String pawdenum;
	UserEnum(int nameenum, String pawdenum){
		this.nameenum = nameenum;
		this.pawdenum = pawdenum;
	}
}
