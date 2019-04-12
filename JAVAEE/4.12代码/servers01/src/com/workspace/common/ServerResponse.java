package com.workspace.common;


/**
 * @author 74140
 *ǰ�˸���Ӧ���õĶ���
 * 
 */
public class ServerResponse<T> {

	private int status;
	private String msg;
	private T date;
	
	
/**
 * @author 74140
 *���ص��ͻ��˵ĸ�ʽ
 *{status:0,"msg":"",date:"obj"}
 *���췽��
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
	 * �ж��Ƿ���Ӧ�ɹ�
	 */
	public boolean isSucess() {
		return status == 0;
	}
	
	/**
	 * @return
	 * �ӿڵ��óɹ�
	 * ��ô����˽�л��ķ���
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
	 * �ӿ�ʵ��ʧ�ܵ����
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
