package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Course;
import com.workspace.common.ServerResponse;
import com.workspace.service.impl.AdminCourseImpl;
import com.workspace.userenum.AdminCourseEnum;

/**
 * Servlet implementation class AdminCourseServlet
 */
@WebServlet("/AdminCourseServlet")
public class AdminCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCourseServlet() {
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
		AdminCourseImpl aci = AdminCourseImpl.getInstance();
		
		if(choose == null) {
			ServerResponse sr = ServerResponse.createServerResponseBySucess(3, "必须传入真实的数据！！");
			Gson gson = new Gson();
			String teststatus = gson.toJson(sr);
			pw.write(teststatus);
			pw.close();
		}
		try {
			int _choose = Integer.parseInt(choose);
			if(_choose == AdminCourseEnum.ADD_COURSE.getCourse_type()) {
				String _cid = request.getParameter("cid");
				int cid = Integer.parseInt(_cid);
				String cname = request.getParameter("cname");
				ServerResponse<Course> cs = aci.addCourse(cid, cname);
				if(cs.isSucess()) {
					session.setAttribute("course", cs.getDate());
					Gson gson = new Gson();
					String information = gson.toJson(cs);
					Cookie cookie_cid = new Cookie("course", information);
					//response.addCookie(cookie_cid);
					
					
				}
				ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "添加结果", cs);
				Gson gson = new Gson();
				String teststatus2 = gson.toJson(sr);
				pw.write(teststatus2);
				
			}else if(_choose == AdminCourseEnum.FX_COURSE.getCourse_type()) {
				String _cid = request.getParameter("cid");
				int cid = Integer.parseInt(_cid);
				String cname = request.getParameter("cname");
				ServerResponse<Course> cs = aci.updateCourse(cid, cname);
				if(cs.isSucess()) {
					session.setAttribute("course", cs.getDate());
					ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "修改结果", cs);
					Gson gson = new Gson();
					String pro_course = gson.toJson(sr);
					pw.write(pro_course);
				}			
			}else if(_choose == AdminCourseEnum.DEL_COURSE.getCourse_type()) {
				String _cid = request.getParameter("cid");
				int cid = Integer.parseInt(_cid);
				ServerResponse<Course> cs = aci.delCourse(cid);
				if(cs.isSucess()) {
					session.setAttribute("course", cs.getDate());
					ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "删除结果", cs);
					Gson gson = new Gson();
					String pro_course = gson.toJson(sr);
					pw.write(pro_course);
				}
			}else if(_choose == AdminCourseEnum.FIND_COURSE.getCourse_type()) {
				ServerResponse<Course> cs = aci.findCourseAll();
				Gson gson = new Gson();
				String pro_course = gson.toJson(cs);
				pw.write(pro_course);
			}
			
		} catch (RuntimeException e) {
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
