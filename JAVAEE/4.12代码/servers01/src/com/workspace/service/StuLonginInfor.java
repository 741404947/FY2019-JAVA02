package com.workspace.service;

import java.util.HashMap;
import java.util.Map;

import com.workspace.admin.Course;
import com.workspace.admin.StuCourse;
import com.workspace.common.ServerResponse;

public interface StuLonginInfor {

	Map<String, Course> course_shop = new HashMap<String, Course>();
	
	public ServerResponse<StuCourse> login(String stuname, String stupassword);
	

}
