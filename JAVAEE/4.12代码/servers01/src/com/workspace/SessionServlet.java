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
import com.workspace.common.ServerResponse;
import com.workspace.service.LoginInfortion;
import com.workspace.service.impl.Loginimpl;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");*/
		
		HttpSession session = request.getSession();
		String tokenid = session.getId();
		System.out.println(tokenid);
		
		session.getAttribute("user");
		String username = null;
		String password = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				String cookie_name = c.getName();
				String cookie_value = c.getValue();
				String cookie_domain = c.getDomain();
				int cookie_version = c.getVersion();
				String cookie_comment = c.getComment();
				
				if(cookie_name.equals("username")) {
					username = cookie_value;
				}
				if(cookie_name.equals("password")) {
					password = cookie_value;
				}
			}
		}
		if(username != null && password != null) {
			LoginInfortion linfor = Loginimpl.getInstance();
			ServerResponse sr = linfor.login(username, password);
			Gson gson = new Gson();
			String testinfor = gson.toJson(sr);
			PrintWriter pw = response.getWriter();
			pw.write(testinfor);
			pw.close();
		}
		
		
		
		//保存课程信息
		session.getAttribute("course");
		Cookie[] cookies_course = request.getCookies();
		String cid = null;
		String cname = null;
		for (int i = 0; i < cookies_course.length; i++) {
			Cookie c = cookies_course[i];
			String cookie_cid = c.getName();
			String cookie_cname = c.getValue();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
