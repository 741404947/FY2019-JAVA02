package com.workspace.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *������������ʵʱ������������
 */
@WebListener
public class LoginListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("==========attributeAdded==============");
    	ServletContext svct = event.getSession().getServletContext();
    	if(event.getName().equals("user")) {
    		Integer online = (Integer)svct.getAttribute("user");
    		if(online == null) {
				online = 1;
				svct.setAttribute("user", 1);
			}else {
				svct.setAttribute("user", ++online);
			}
    	}
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("==========attributeRemoved==============");

    	ServletContext svct = event.getSession().getServletContext();
    	
    	Integer num = (Integer)svct.getAttribute("user");
		if(num == null) {
			num = 0;
		}else {
			num--;
		}
		svct.setAttribute("user", num);
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    	System.out.println("==========attributeReplaced==============");
    	//��ֹ�����½
    	HttpSession session = event.getSession();
    	Object o = session.getAttribute("user");
    	if(o != null) {
    		return;
    	}
    	//�����ѯ��������
    	ServletContext svct = session.getServletContext();
    	if(event.getName().equals("user")) {
    		Integer online = (Integer)svct.getAttribute("user");
    		if(online == null) {
				online = 1;
				svct.setAttribute("user", 1);
			}else {
				svct.setAttribute("user", ++online);
			}
    	} 
    }
	
}
