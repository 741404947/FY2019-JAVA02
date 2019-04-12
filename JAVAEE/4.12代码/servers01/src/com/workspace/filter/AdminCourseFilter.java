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
import com.workspace.common.ServerResponse;

/**
 * Servlet Filter implementation class AdminCourseFilter
 */
@WebFilter("/AdminCourseServlet")
public class AdminCourseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminCourseFilter() {
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

		// pass the request along the filter chain
		request.setCharacterEncoding("utf-8");
		response.setContentType("test/html;charset=utf-8");
		//将ServletRequest向下转型
		HttpServletRequest _request = (HttpServletRequest)request;
		//判断是否登陆过
		HttpSession session = _request.getSession();
		Admin admin = (Admin)session.getAttribute("user");
		if(admin == null) {
			//未登录
			PrintWriter pw = response.getWriter();
			ServerResponse sr = ServerResponse.createServerResponseByFail(8, "未登录");
			Gson gson = new Gson();
			String textend = gson.toJson(sr);
			pw.write(textend);
			pw.close();
			return;
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
