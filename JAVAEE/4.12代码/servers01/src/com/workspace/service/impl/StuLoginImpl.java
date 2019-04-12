package com.workspace.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.workspace.admin.Admin;
import com.workspace.admin.StuCourse;
import com.workspace.common.ServerResponse;
import com.workspace.service.StuLonginInfor;

public class StuLoginImpl implements StuLonginInfor {

	private static StuLoginImpl sli = null;
	static Map<String, StuCourse> stucourses = new HashMap<String, StuCourse>();
	
	private StuLoginImpl() {
		StuCourse sc1 = new StuCourse("xuyuhao", "xuyuhao250");
		stucourses.put(sc1.getStuname(), sc1);
	}
	public static synchronized StuLoginImpl getInstance() {
		if(sli == null) {
			sli = new StuLoginImpl();
		}
		return sli;
	}
	@Override
	public ServerResponse<StuCourse> login(String stuname, String stupassword) {
		// TODO Auto-generated method stub
		if(stuname == null || stuname.equals("")) {
			return ServerResponse.createServerResponseByFail(5, "�û�������Ϊ�գ���");
		}
		if(stupassword == null || stupassword.equals("")) {
			return ServerResponse.createServerResponseByFail(6, "���벻��Ϊ�գ���");
		}
		
		boolean isusernameexit = isusernameexit(stuname);
		
		if(isusernameexit) {
			StuCourse stucourse = stucourses.get(stuname);
			String _password = stucourse.getStupassword();
			//String _username = admin.getUsername();
			if(_password.equals(stupassword)) {
				return ServerResponse.createServerResponseBySucess(0, "��½�ɹ���",stucourse);
			}else {
				return ServerResponse.createServerResponseBySucess(9, "������û���ƥ�䣡");
			}
		}
		
		return ServerResponse.createServerResponseBySucess(8, "�û��������ڣ�");
	}
	
	public boolean isusernameexit(String stuname) {
		return stucourses.containsKey(stuname);
	}



}
