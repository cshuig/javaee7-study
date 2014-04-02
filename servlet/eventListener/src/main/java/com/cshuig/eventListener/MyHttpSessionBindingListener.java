package com.cshuig.eventListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 类名		: MyHttpSessionBindingListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:32:32
 * 功能描述{
 *	1、
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyHttpSessionBindingListener implements HttpSessionBindingListener{

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("执行：MyHttpSessionBindingListener.valueBound(); " +
				"name=" + event.getName() + "\n"+
				"value=" + event.getValue() + "\n"+
				"sessionId=" + event.getSession().getId());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("执行：MyHttpSessionBindingListener.valueUnbound(); " +
				"name=" + event.getName() + "\n"+
				"value=" + event.getValue() + "\n"+
				"sessionId=" + event.getSession().getId());
	}

}


