package com.neuedu;

public interface UserBiz {
	public void register(String username, String password, String password2, String name, String email)throws RegisterException;
	
	public void login(String username, String password)throws LoginException;
	
	public boolean isUsername(String username)throws LoginException;
	
	public boolean isUsernameexit(String username)throws RegisterException;
	
	public boolean isPassword(String password , String password2)throws RegisterException;
}
