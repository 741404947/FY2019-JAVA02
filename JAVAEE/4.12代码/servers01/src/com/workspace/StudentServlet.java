package com.workspace;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Admin;
import com.workspace.admin.Student;
import com.workspace.common.ServerResponse;
import com.workspace.service.impl.StudentImpl;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
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
		String choose = request.getParameter("choose");
		PrintWriter pw = response.getWriter();
		StudentImpl si = StudentImpl.getInstance();
		
		
/*		//利用过滤器来进行业务逻辑判读
		//判断是否登陆过
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("user");
		if(admin == null) {
			//未登录
			ServerResponse sr = ServerResponse.createServerResponseByFail(8, "未登录");
			Gson gson = new Gson();
			String textend = gson.toJson(sr);
			pw.write(textend);
			pw.close();
			return;
		}
		*/
		
		if(choose == null) {
			ServerResponse sr = ServerResponse.createServerResponseBySucess(3, "必须传入真实的数据！！");
			Gson gson = new Gson();
			String teststatus = gson.toJson(sr);
			pw.write(teststatus);
			pw.close();
		}
		try {
			
				int _choose = Integer.parseInt(choose);
				
				if(_choose == 3) {
					//查询所有信息页面
					List<Student> l1 = si.findAll();
					ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "查询结果", l1);
					Gson gson = new Gson();
					String teststatus = gson.toJson(sr);
					pw.write(teststatus);
					pw.close();
					
				}else if(_choose == 4) {
					//删除信息页面
					//String teststatus = "{\"status\":4,\"msg\":\"正在努力加载中！\"}";
					String del_id = request.getParameter("id");
					int id = Integer.parseInt(del_id);
					boolean del_isid = si.del_isid(id);
					if(del_isid) {
						List<Student> lt = si.delStudent(id);
						ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "删除完成", lt);
						Gson gson = new Gson();
						String teststatus = gson.toJson(sr);
						pw.write(teststatus);
						pw.close();
					}
				}else if(_choose == 5) {
					//修改信息页面
					//String teststatus = "{\"status\":5,\"msg\":\"正在努力加载中！\"}";
					Date date = new Date(System.currentTimeMillis());
					SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
					String update_id = request.getParameter("id");
					int id = Integer.parseInt(update_id);
					boolean update_isid = si.update_id(id);
					if(update_isid) {
						String text = request.getParameter("text");
						String newtext = request.getParameter("newtext");
						String _date = format.format(date);
						List<Student> lt = si.updateStudent(id, text, newtext, _date);
						ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "修改完成", lt);
						Gson gson = new Gson();
						String teststatus = gson.toJson(sr);
						pw.write(teststatus);
						pw.close();
					}
				}else if(_choose == 6) {
					//增加信息页面
					//String teststatus = "{\"status\":6,\"msg\":\"正在努力加载中！\"}";
					Date date = new Date(System.currentTimeMillis());
					SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
					String stu_id = request.getParameter("id");
					int id = Integer.parseInt(stu_id);
					boolean isid = si.isid(id);
					if(isid) {
						String stu_username = request.getParameter("username");
						String stu_age = request.getParameter("age");
						String stu_sex = request.getParameter("sex");
						String stu_school = request.getParameter("school");
						String stu_address = request.getParameter("address");
						String stu_phone = request.getParameter("phone");
						String stu_email = request.getParameter("email");
						String stu_score = request.getParameter("score");
						int score = Integer.parseInt(stu_score);
						String stu_date = format.format(date);
						List<Student> l1 = si.addStudent(id, stu_username, stu_age, stu_sex, stu_school, stu_address, stu_phone, stu_email, score, stu_date);
						ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "添加结果", l1);
						Gson gson = new Gson();
						String teststatus2 = gson.toJson(sr);
						pw.write(teststatus2);
						pw.close();
					}else {
						String teststatus2 = "{\"status\":7,\"msg\":\"输入的id已经存在！\"}";
						pw.write(teststatus2);
						pw.close();
					}
				
			}else if(_choose == 7) {
				String find_id = request.getParameter("id");
				int id = Integer.parseInt(find_id);
				Student s1 = si.findStudentById(id);
				ServerResponse sr = ServerResponse.createServerResponseBySucess(0, "该学生信息", s1);
				Gson gson = new Gson();
				String teststatus = gson.toJson(sr);
				pw.write(teststatus);
				pw.close();
			}
		}catch (RuntimeException e) {
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
