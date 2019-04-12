package com.workspace.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.workspace.admin.Admin;
import com.workspace.admin.Course;
import com.workspace.common.ServerResponse;
import com.workspace.service.AdminCourse;


public class AdminCourseImpl implements AdminCourse {
	private static AdminCourseImpl aci;
	
	static Map<Integer, Course> courses = new HashMap<Integer, Course>();
	
	//单例模式
	
	private AdminCourseImpl(){
		Course course1 = new Course(1, "java");
		Course course2 = new Course(2, "html");
		Course course3 = new Course(3, "数据结构");
		courses.put(course1.getCid(), course1);
		courses.put(course2.getCid(), course2);
		courses.put(course3.getCid(), course3);
	}
	
	public synchronized static AdminCourseImpl getInstance() {
		if(aci == null) {
			aci = new AdminCourseImpl();
		}
		return aci;
	}

	@Override
	public ServerResponse<Course> addCourse(int cid, String cname) {
		// TODO Auto-generated method stub
		boolean iscid = false;
		Collection<Course> course = courses.values();
		Iterator<Course> iterable = course.iterator();
		while(iterable.hasNext()) {
			Course c = iterable.next();
			if(c.getCid() == cid) {
				iscid = true;
				break;
			}
		}
		if(!iscid) {
			Course newcourse = new Course(cid, cname);
			courses.put(newcourse.getCid(), newcourse);
		}else {
			return ServerResponse.createServerResponseByFail(250, "cid已经存在！！");
		}
		
		return ServerResponse.createServerResponseBySucess(0, "添加课程", courses);
	}
	public boolean iscidexit(int cid) {
		return courses.containsKey(cid);
	}

	@Override
	public ServerResponse<Course> updateCourse(int cid, String cname) {
	
		// TODO Auto-generated method stub	
		
			Course c = courses.get(cid);
			c.setCname(cname);
			return ServerResponse.createServerResponseBySucess(0, "修改课程", c);	
	}

	@Override
	public ServerResponse<Course> delCourse(int cid) {
		
		// TODO Auto-generated method stub
		
		boolean iscid = false;
		Collection<Course> course = courses.values();
		Iterator<Course> iterable = course.iterator();
		while(iterable.hasNext()) {
			Course c = iterable.next();
			if(c.getCid() == cid) {
				iscid = true;
				break;
			}
		}
		if(iscid) {
			courses.remove(cid);
			return ServerResponse.createServerResponseBySucess(0, "删除课程", courses);
		}else {
			return ServerResponse.createServerResponseByFail(250, "cid不存在！！");
		}
		
		
	}

	@Override
	public ServerResponse<Course> findCourseBycid(int cid) {
		// TODO Auto-generated method stub
		//Course c = courses.get(cid);
		if(courses.containsKey(cid)) {
			Course c = courses.get(cid);
			return ServerResponse.createServerResponseBySucess(0, "查询该cid", c);
		}
		return ServerResponse.createServerResponseByFail(250, "查无此cid");
	}

	@Override
	public ServerResponse<Course> findCourseAll() {
		// TODO Auto-generated method stub
		return ServerResponse.createServerResponseBySucess(0, "查询所有课程", courses.values());	
	}
}
