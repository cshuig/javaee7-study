package com.cshuig.eventListener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * 类名		: MyServletRequestAttributeListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:21:41
 * 功能描述{
 *	1、用于监听ServletRequest（request）范围内属性的变化,如增加、删除、修改操作
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("执行：MyServletRequestAttributeListener.attributeAdded(); key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("执行：MyServletRequestAttributeListener.attributeRemoved(); key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("执行：MyServletRequestAttributeListener.attributeReplaced; key=["+event.getName()+"],value=["+event.getValue()+"]");
	}

}


