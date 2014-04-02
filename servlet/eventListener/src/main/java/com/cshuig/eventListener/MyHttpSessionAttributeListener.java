package com.cshuig.eventListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 类名		: MyHttpSessionAttributeListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:42:25
 * 功能描述{
 *	1、监听HttpSession中属性的操作。
 *		1.1、当在Session增加一个属性时，激发attributeAdded(HttpSessionBindingEvent event) 方法；
 *		1.2、当在Session删除一个属性时，激发attributeRemoved(HttpSessionBindingEvent event)方法；
 *		1.3、在Session属性被重新设置时，激发attributeReplaced(HttpSessionBindingEvent event) 方法
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("执行：MyHttpSessionAttributeListener.attributeAdded(); " +
				"key=["+event.getName()+"]" +
				"value=["+event.getValue()+"]");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("执行：MyHttpSessionAttributeListener.attributeRemoved(); " +
				"key=["+event.getName()+"]" +
				"value=["+event.getValue()+"]");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("执行：MyHttpSessionAttributeListener.attributeReplaced(); " +
				"key=["+event.getName()+"]" +
				"value=["+event.getValue()+"]");
	}

}


