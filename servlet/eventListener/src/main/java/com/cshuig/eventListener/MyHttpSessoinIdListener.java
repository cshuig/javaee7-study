package com.cshuig.eventListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

/**
 * 类名		: MyHttpSessoinIdListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:35:31
 * 功能描述{
 *	1、
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyHttpSessoinIdListener implements HttpSessionIdListener{

	@Override
	public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
		System.out.println("执行：MyHttpSessoinIdListener.sessionIdChanged(); " +
				"newSessionId=" + event.getSession().getId() +
				"oldSessionId=" + oldSessionId );
	}

}


