package com.cshuig.eventListener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 类名		: MyServletContextAttributeListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:27:43
 * 功能描述{
 *	1、用于监听ServletContext（application）范围内属性的变化,如增加、删除、修改操作
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		System.out.println("执行：MyServletContextAttributeListener.attributeAdded(); " +
				"key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		System.out.println("执行：MyServletContextAttributeListener.attributeRemoved(); " +
				"key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		System.out.println("执行：MyServletContextAttributeListener.attributeReplaced(); " +
				"key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

}


