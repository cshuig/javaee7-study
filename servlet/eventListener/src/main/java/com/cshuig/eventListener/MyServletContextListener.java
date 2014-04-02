package com.cshuig.eventListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 类名		: MyServletContextListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:25:33
 * 功能描述{
 *	1、监听ServletContext，
 *		1.1、当创建ServletContext时，激发contextInitialized (ServletContextEvent sce)方法
 *		1.2、当销毁ServletContext时，激发contextDestroyed(ServletContext- Event sce)方法
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("执行：MyServletContextListener.contextInitialized();");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("执行：MyServletContextListener.contextDestroyed();");
	}

}


