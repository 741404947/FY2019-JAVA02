package com.workspace.service;

import java.util.List;

import com.workspace.admin.Course;
import com.workspace.admin.StuCourse;
import com.workspace.common.ServerResponse;

public interface StuChoiseCourse {

	public ServerResponse addStuCourse(int cid, List<Course> courses);
	
	public ServerResponse delStuCourse(int cid, List<Course> courses);
}
