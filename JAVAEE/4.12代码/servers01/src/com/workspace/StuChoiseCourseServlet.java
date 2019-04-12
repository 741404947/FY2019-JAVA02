package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Course;
import com.workspace.admin.Student;
import com.workspace.common.ServerResponse;
import com.workspace.service.impl.StuChoiseCourseImpl;
import com.workspace.userenum.StudentEnum;

/**
 * Servlet implementation class StuChoiseCourse
 */
@WebServlet("/StuChoiseCourseServlet")
public class StuChoiseCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuChoiseCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取学生的会话
		HttpSession session = request.getSession();
		List<Course> courses = (List<Course>) session.getAttribute("shop");
		Student student = (Student) session.getAttribute("Student");
		//发送请求
		String choose = request.getParameter("choose");
		PrintWriter pw = response.getWriter();
		//构造方法
		StuChoiseCourseImpl scc = new StuChoiseCourseImpl();
		if(choose == null) {
			ServerResponse sr = ServerResponse.createServerResponseBySucess(3, "必须传入真实的数据！！");
			Gson gson = new Gson();
			String teststatus = gson.toJson(sr);
			pw.write(teststatus);
			pw.close();
		}
		
		try {
			int _choose = Integer.parseInt(choose);
			if(_choose == StudentEnum.STU_XUAN_COURSE.getStu_type()) {
				String _cid = request.getParameter("cid");
				int cid = Integer.parseInt(_cid);
				ServerResponse<Student> s = scc.addStuCourse(cid, courses);
				Gson gson = new Gson();
				String pro_course = gson.toJson(s);
				pw.write(pro_course);
				pw.close();
				
			}else if(_choose == StudentEnum.STU_SHAN_COURSE.getStu_type()) {
				String _cid = request.getParameter("cid");
				int cid = Integer.parseInt(_cid);
				ServerResponse<Student> s = scc.delStuCourse(cid, courses);
				Gson gson = new Gson();
				String pro_course = gson.toJson(s);
				pw.write(pro_course);
				pw.close();
			}else if(_choose == StudentEnum.STU_FIN_COURSE.getStu_type()) {
				ServerResponse<Student> sr = ServerResponse.createServerResponseBySucess(0, "查看已选课程", courses);
				Gson gson = new Gson();
				String pro_course = gson.toJson(sr);
				pw.write(pro_course);
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
