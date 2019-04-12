package com.workspace.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.workspace.admin.Admin;
import com.workspace.admin.StuCourse;
import com.workspace.common.ServerResponse;

/**
 * Servlet Filter implementation class StuLoginFilter
 */
@WebFilter("/StuChoiseCourseServlet")
public class StuLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public StuLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		//将ServletRequest向下转型
		HttpServletRequest _request = (HttpServletRequest)request;
		//判断是否登陆过
		HttpSession session = _request.getSession();
		StuCourse stucourse = (StuCourse)session.getAttribute("stu_login");
		if(stucourse == null) {
			//未登录
			PrintWriter pw = response.getWriter();
			ServerResponse sr = ServerResponse.createServerResponseByFail(8, "未登录");
			Gson gson = new Gson();
			String textend = gson.toJson(sr);
			pw.write(textend);
			pw.close();
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
