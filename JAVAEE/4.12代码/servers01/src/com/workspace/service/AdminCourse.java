package com.workspace.service;

import java.util.Map;

import com.workspace.admin.Admin;
import com.workspace.admin.Course;
import com.workspace.common.ServerResponse;

public interface AdminCourse {

	public ServerResponse<Course> addCourse(int cid, String cname);
	
	public ServerResponse<Course> updateCourse(int cid, String cname);
	
	public ServerResponse<Course> delCourse(int cid);
	
	public ServerResponse<Course> findCourseBycid(int cid);
	
	public ServerResponse<Course> findCourseAll();
}
