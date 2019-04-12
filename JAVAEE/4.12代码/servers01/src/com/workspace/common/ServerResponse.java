package com.workspace.common;


/**
 * @author 74140
 *前端高响应可用的对象
 * 
 */
public class ServerResponse<T> {

	private int status;
	private String msg;
	private T date;
	
	
/**
 * @author 74140
 *返回到客户端的格式
 *{status:0,"msg":"",date:"obj"}
 *构造方法
 *
 */
	private ServerResponse() {
		super();
	}

	private ServerResponse(int status) {
		super();
		this.status = status;
	}

	private ServerResponse(int status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}

	private ServerResponse(int status, T date) {
		super();
		this.status = status;
		this.date = date;
	}

	private ServerResponse(int status, String msg, T date) {
		super();
		this.status = status;
		this.msg = msg;
		this.date = date;
	}
	
	
	/**
	 * @return
	 * 判断是否响应成功
	 */
	public boolean isSucess() {
		return status == 0;
	}
	
	/**
	 * @return
	 * 接口调用成功
	 * 怎么调用私有化的方法
	 * 
	 */
	public static <T> ServerResponse createServerResponseBySucess() {
		return new ServerResponse<T>() ;
	}
	
	public static <T> ServerResponse createServerResponseBySucess(int status) {
		return new ServerResponse<T>(status) ;
	}
	
	public static <T> ServerResponse createServerResponseBySucess(int status, String msg) {
		return new ServerResponse<T>(status, msg) ;
	}
	
	public static <T> ServerResponse createServerResponseBySucess(int status, T date) {
		return new ServerResponse<T>(status, date) ;
	}
	
	public static <T> ServerResponse createServerResponseBySucess(int status, String msg, T date) {
		return new ServerResponse<T>(status, msg, date) ;
	}

	/**
	 * @return
	 * 接口实现失败的情况
	 * 
	 */
	public static <T> ServerResponse createServerResponseByFail() {
		return new ServerResponse<T>();
	}
	public static <T> ServerResponse createServerResponseByFail(int status) {
		return new ServerResponse<T>(status);
	}
	public static <T> ServerResponse createServerResponseByFail(int status, String msg) {
		return new ServerResponse<T>(status, msg);
	}
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}
	

	
}
