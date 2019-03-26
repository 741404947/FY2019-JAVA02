package com.neuedu;

public interface UserBiz {
	public void register(String username, String password, String password2, String name, String email)throws RegisterException;
	
	public void login(String username, String password)throws LoginException;
	
}
