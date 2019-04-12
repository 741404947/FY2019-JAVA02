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
		
		//����cid��ѯ�γ�
		AdminCourse ac = AdminCourseImpl.getInstance();
		ServerResponse<Course> sr = ac.findCourseBycid(cid);
		if(sr.isSucess()) {
						//��ȡ���γ�
						Course c = sr.getDate();
						courses.add(c);
						return ServerResponse.createServerResponseBySucess(0, "��ӿγ̳ɹ�", courses);					
		}
		
		return ServerResponse.createServerResponseByFail(250, "ѡ��Ŀγ̲�����/�Ѿ��¼ܣ���");
	}

	@Override
	public ServerResponse delStuCourse(int cid, List<Course> courses) {
		// TODO Auto-generated method stub
		AdminCourse ac = AdminCourseImpl.getInstance();
		ServerResponse<Course> sr = ac.findCourseBycid(cid);
		if(sr.isSucess()) {
			Course c= sr.getDate();
			courses.remove(c);
			return ServerResponse.createServerResponseBySucess(0, "ɾ���γ�", courses);
		}
		return ServerResponse.createServerResponseByFail(250, "Ҫɾ���Ŀγ̲����ڣ�");
	}

}
