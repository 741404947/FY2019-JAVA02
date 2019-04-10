package com.workspace.userenum;

public enum UserEnum {

	LOGIN(1,"µÇÂ½"),REGISTER(2,"×¢²á");
	private int nameenum;
	private String pawdenum;
	UserEnum(int nameenum, String pawdenum){
		this.nameenum = nameenum;
		this.pawdenum = pawdenum;
	}
}
