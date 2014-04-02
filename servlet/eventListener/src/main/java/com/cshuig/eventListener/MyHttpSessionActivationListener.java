package com.cshuig.eventListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 类名		: MyHttpSessionActivationListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:38:33
 * 功能描述{
 *	1、用于监听Http会话active、passivate情况
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyHttpSessionActivationListener implements HttpSessionActivationListener{

	@Override
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("执行：MyHttpSessionActivationListener.sessionDidActivate()" +
				"" + event.getSession().getId() );
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("执行：MyHttpSessionActivationListener.sessionWillPassivate()" +
				"" + event.getSession().getId() );
	}

}


