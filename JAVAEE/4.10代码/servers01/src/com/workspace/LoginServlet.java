package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Admin;
import com.workspace.common.ServerResponse;
import com.workspace.service.LoginInfortion;
import com.workspace.service.impl.Loginimpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("====doget====");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		
		Loginimpl li = Loginimpl.getInstance();
		PrintWriter pw = response.getWriter();
		String choose = request.getParameter("choose");
		
		if(choose == null) {
			//返回客户端
			String teststatus = "{\"status\":2,\"msg\":\"输入的数字不正确！\"}";
			pw.write(teststatus);
			pw.close();
			
		}else {
			if(choose.equals("1")) {
				//登陆成功
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				LoginInfortion lifor = Loginimpl.getInstance();
				
				ServerResponse<Admin> check = lifor.login(username, password);
				
				if(check.isSucess()) {
					 session.setAttribute("user", true);
					 //创建cooke
					 Cookie uesrname_cookie = new Cookie("username", username);
					 //设置过期时间
					 uesrname_cookie.setMaxAge(7*24*3600);
					 //将其写到客户端
					 response.addCookie(uesrname_cookie);
					 Cookie password_cookie = new Cookie("password", password);
					 password_cookie.setMaxAge(2*24*3600);
					 response.addCookie(password_cookie);
				}
				
				Gson gson = new Gson();
				String teststatus = gson.toJson(check);
				pw.write(teststatus);
				pw.close();
				}else if(choose.equals("2")) {
					//注册页面
					String teststatus = "{\"status\":2,\"msg\":\"正在努力加载中！\"}";
					
				}
			else {
				//返回客户端
				String teststatus = "{\"status\":3,\"msg\":\"请输入可执行的数字！\"}";
				pw.write(teststatus);
				pw.close();
			}
		}
		
		
		
		System.out.println("====dopost====");

		
	}

}
