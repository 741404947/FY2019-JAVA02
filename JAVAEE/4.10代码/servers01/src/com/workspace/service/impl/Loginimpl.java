package com.workspace.service.impl;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.workspace.admin.Admin;
import com.workspace.admin.Student;
import com.workspace.common.ServerResponse;
import com.workspace.service.LoginInfortion;

public class Loginimpl implements LoginInfortion {
		private static Loginimpl li;
		
		Map<String, Admin> admins = new HashMap<String , Admin>();
		
	
		/**
		 * k--->����Ա�û���
		 * v--->����Ա����
		 */
		private Loginimpl() {
			// TODO Auto-generated constructor stub
			Admin admin1 = new Admin("admin", "admin");
			Admin admin2 = new Admin("zhangsan", "xyh");
			admins.put(admin1.getUsername(), admin1);
			admins.put(admin2.getUsername(), admin2);
			
		}
		
		public synchronized static Loginimpl getInstance() {
			 if(li == null) {
				 li = new Loginimpl();
			 }
			return li;
			
		}
	@Override
	public ServerResponse<Admin> login(String username, String password) {
		// TODO Auto-generated method stub
		if(username == null || username.equals("")) {
			return ServerResponse.createServerResponseByFail(5, "�û�������Ϊ�գ���");
		}
		if(password == null || password.equals("")) {
			return ServerResponse.createServerResponseByFail(6, "���벻��Ϊ�գ���");
		}
		
		boolean isusernameexit = isusernameexit(username);
		
		if(isusernameexit) {
			
			Admin admin = admins.get(username);
			String _password = admin.getPassword();
			//String _username = admin.getUsername();
			if(_password.equals(password)) {
				return ServerResponse.createServerResponseBySucess(0, "��½�ɹ���");
			}else {
				return ServerResponse.createServerResponseBySucess(9, "������û���ƥ�䣡");
			}
		}
		
		return ServerResponse.createServerResponseBySucess(8, "�û��������ڣ�");
	}
	
	public boolean isusernameexit(String username) {
		return admins.containsKey(username);
	}

}
