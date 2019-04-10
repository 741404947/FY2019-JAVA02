package com.workspace.service;

import com.workspace.admin.Admin;
import com.workspace.common.ServerResponse;

public interface LoginInfortion {
	
	public ServerResponse<Admin> login(String username, String password);
	
}
