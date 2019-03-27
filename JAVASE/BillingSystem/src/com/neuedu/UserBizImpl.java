package com.neuedu;

public class UserBizImpl implements UserBiz{

	User[] users = new User[5];
	
	public UserBizImpl() {
		User user1 = new User("admin", "admin", "Administrator", "admin@123.com");
		User user2 = new User("tom", "cat", "tomcat", "tomcat@cat.com");
		users[0] = user1;
		users[1] = user2;
	}

	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < users.length; i++) {
			if(users[i] == null) {
				continue;
			}
			if(users[i].username.equals(username)) {
				usernameexit = true;
			}
		}
		if(usernameexit) {
				throw new RegisterException("用户名已经存在！！！");
			}
		if(!password.equals(password2)) {
			throw new RegisterException("两次输入密码不一致！！！");
		}
		User user3 = new User(username, password, name, email);
		users[3] = user3;
	}
	
	@Override
	public boolean isUsernameexit(String username) throws RegisterException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < users.length; i++) {
			if(users[i] == null) {
				continue;
			}
			if(!users[i].username.equals(username)) {
				return true;
			}else {
				throw new RegisterException("用户名已经存在！！！");
			}
		}
		return usernameexit;
	}	
	@Override
	public boolean isPassword(String password, String password2) throws RegisterException {
		// TODO Auto-generated method stub
		boolean passwordexit = false;
		if(password.equals(password2)) {
			return true;
		}
		throw new RegisterException("两次输入密码不一致！！！");
	}

	
	
	
	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < users.length; i++) {
			if(users[i]== null) {
				continue;
			}
			if(username.equals(users[i].username)) {
				usernameexit = true;
				if(password.equals(users[i].password)) {
					System.out.println("登陆成功！！！");
					System.out.println("欢迎您：" + username);
					break;
				}else {
					throw new LoginException("输入的用户名和密码不正确！！！");
				}
			}	
		}
		if(!usernameexit) {
			throw new LoginException("用户不存在！！！");	
		}	
	}

	@Override
	public boolean isUsername(String username) throws LoginException {
		// TODO Auto-generated method stub
		boolean usernameexit = false;
		for (int i = 0; i < users.length; i++) {
			if(users[i]== null) {
				continue;
			}
			if(username.equals(users[i].username)) {
				return true;
				}
			}	
		throw new LoginException("用户不存在！！！");	
	}


	

	
}
