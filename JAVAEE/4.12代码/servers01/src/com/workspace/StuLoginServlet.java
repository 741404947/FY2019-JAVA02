package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Admin;
import com.workspace.admin.Course;
import com.workspace.admin.StuCourse;
import com.workspace.admin.Student;
import com.workspace.common.ServerResponse;
import com.workspace.service.LoginInfortion;
import com.workspace.service.StuLonginInfor;
import com.workspace.service.impl.Loginimpl;
import com.workspace.service.impl.StuLoginImpl;
import com.workspace.userenum.StudentEnum;

/**
 * Servlet implementation class StuLoginServlet
 */
@WebServlet("/StuLoginServlet")
public class StuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String choose = request.getParameter("choose");
		PrintWriter pw = response.getWriter();
		StuLonginInfor slif = StuLoginImpl.getInstance();
		if(choose == null) {
			String teststatus = "{\"status\":2,\"msg\":\"输入的数字不正确！\"}";
			pw.write(teststatus);
			pw.close();
		}
		try {
			int _choose = Integer.parseInt(choose);
			if(_choose == StudentEnum.STU_LOGIN.getStu_type()) {
					//登陆成功
				
				HttpSession session_course = request.getSession();
				//建立一个会话
				session.setAttribute("Student", new Student(1 , "huqisheng", "nv", "12", "chuzhong", "riben", "250", "250@250", 59, "19-4-1 10:55:05"));
				//建立一个购物车的会话
				session.setAttribute("shop", new ArrayList<Course>());
				String stuname = request.getParameter("stuname");
				String stupassword = request.getParameter("stupassword");
				
				LoginInfortion lifor = Loginimpl.getInstance();
				
				ServerResponse<StuCourse> check = slif.login(stuname, stupassword);
				
				if(check.isSucess()) {
					 session.setAttribute("stu_login", check.getDate());
					 //创建cookie
					 Cookie uesrname_cookie = new Cookie("stuname", stuname);
					 //设置过期时间
					 uesrname_cookie.setMaxAge(7*24*3600);
					 //将其写到客户端
					 response.addCookie(uesrname_cookie);
					 Cookie password_cookie = new Cookie("stupassword", stupassword);
					 password_cookie.setMaxAge(2*24*3600);
					 response.addCookie(password_cookie);		
				}
				
				Gson gson = new Gson();
				String teststatus = gson.toJson(check);
				pw.write(teststatus);
				pw.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			String teststatus = "{\"status\":3,\"msg\":\"请输入可执行的数字！\"}";
			pw.write(teststatus);
			pw.close();
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
