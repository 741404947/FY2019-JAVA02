package com.workspace.service.impl;

import java.util.List;

import com.workspace.admin.Course;
import com.workspace.admin.StuCourse;
import com.workspace.common.ServerResponse;
import com.workspace.service.AdminCourse;
import com.workspace.service.StuChoiseCourse;

public class StuChoiseCourseImpl implements StuChoiseCourse {

	@Override
	public ServerResponse addStuCourse(int cid, List<Course> courses) {
		// TODO Auto-generated method stub
		
		//根据cid查询课程
		AdminCourse ac = AdminCourseImpl.getInstance();
		ServerResponse<Course> sr = ac.findCourseBycid(cid);
		if(sr.isSucess()) {
						//获取到课程
						Course c = sr.getDate();
						courses.add(c);
						return ServerResponse.createServerResponseBySucess(0, "添加课程成功", courses);					
		}
		
		return ServerResponse.createServerResponseByFail(250, "选择的课程不存在/已经下架！！");
	}

	@Override
	public ServerResponse delStuCourse(int cid, List<Course> courses) {
		// TODO Auto-generated method stub
		AdminCourse ac = AdminCourseImpl.getInstance();
		ServerResponse<Course> sr = ac.findCourseBycid(cid);
		if(sr.isSucess()) {
			Course c= sr.getDate();
			courses.remove(c);
			return ServerResponse.createServerResponseBySucess(0, "删除课程", courses);
		}
		return ServerResponse.createServerResponseByFail(250, "要删除的课程不存在！");
	}

}
