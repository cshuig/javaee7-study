package com.cshuig.eventListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 类名		: MyHttpSessionListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:30:40
 * 功能描述{
 *	1、监听HttpSession的操作。
 *		1.2、当创建一个Session时，激发session Created (HttpSessionEvent event)方法；
 *		1.2、当销毁一个Session时，激发sessionDestroyed (HttpSessionEvent event)方法
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("执行：MyHttpSessionListener.sessionCreated(); " +
				"sessionId = " + event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("执行：MyHttpSessionListener.sessionDestroyed(); " +
				"sessionId = " + event.getSession().getId());
	}

}


