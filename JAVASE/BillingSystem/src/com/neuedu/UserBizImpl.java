package com.neuedu;

public class UserBizImpl implements UserBiz{
	public String username;
	public String password;
	public String name;
	public String email;


	public UserBizImpl() {

	}
	
	
	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub
		if(this.username.equals(username)) {
			throw new RegisterException();
		}
		if(password.equals(password2)) {
			throw new RegisterException();
		}
	}


	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		if(username == null) {
			throw new LoginException();
		}
		if(!this.username.equals(username) && !this.password.equals(password)) {
			throw new LoginException();
		}
	}
	
}
