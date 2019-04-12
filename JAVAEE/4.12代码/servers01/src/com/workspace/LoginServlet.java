package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
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
import com.workspace.common.ServerResponse;
import com.workspace.service.LoginInfortion;
import com.workspace.service.impl.AdminCourseImpl;
import com.workspace.service.impl.Loginimpl;
import com.workspace.userenum.UserEnum;

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
		/*request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");*/
		
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		
		Loginimpl li = Loginimpl.getInstance();
		AdminCourseImpl aci = AdminCourseImpl.getInstance();
		PrintWriter pw = response.getWriter();
		String choose = request.getParameter("choose");
		
		//����һ��ȫ����
		ServletContext svct = request.getServletContext();
		int _choose = Integer.parseInt(choose);
		if(choose == null) {
			//���ؿͻ���
			String teststatus = "{\"status\":2,\"msg\":\"��������ֲ���ȷ��\"}";
			pw.write(teststatus);
			pw.close();
			
			
		}else {
			if(_choose == UserEnum.LOGIN.getChoose_type()) {
				//��½�ɹ�
				
				HttpSession session_course = request.getSession();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				LoginInfortion lifor = Loginimpl.getInstance();
				
				ServerResponse<Admin> check = lifor.login(username, password);
				
				if(check.isSucess()) {
					 session.setAttribute("user", check.getDate());
					 //����cookie
					 Cookie uesrname_cookie = new Cookie("username", username);
					 //���ù���ʱ��
					 uesrname_cookie.setMaxAge(7*24*3600);
					 //����д���ͻ���
					 response.addCookie(uesrname_cookie);
					 Cookie password_cookie = new Cookie("password", password);
					 password_cookie.setMaxAge(2*24*3600);
					 response.addCookie(password_cookie);
					 
				
				
						
				}
				
				Gson gson = new Gson();
				String teststatus = gson.toJson(check);
				pw.write(teststatus);
				pw.close();
				}else if(_choose == UserEnum.REGISTER.getChoose_type()) {
					//ע��ҳ��
					String teststatus = "{\"status\":2,\"msg\":\"����Ŭ�������У�\"}";
					
				}else if(_choose == UserEnum.LOGIN_FAIL.getChoose_type()) {
					//�˳���½
					session.removeAttribute("user");
					
				}else if(_choose == UserEnum.PEO_ONLINE.getChoose_type()) {
					//�����������
					Integer online = (Integer)svct.getAttribute("user");
					//System.out.println("user" + online);
					ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "��������:", online);
					Gson gson = new Gson();
					String teststatus = gson.toJson(sr);
					pw.write(teststatus);
					
				}
			else {
				//���ؿͻ���
				String teststatus = "{\"status\":3,\"msg\":\"�������ִ�е����֣�\"}";
				pw.write(teststatus);
				pw.close();
			}
		}
		
		
		
		System.out.println("====dopost====");

		
	}

}
