package com.workspace.admin;

import java.io.Serializable;

public class Course implements Serializable{

	public int cid;
	public String cname;

	public Course(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
