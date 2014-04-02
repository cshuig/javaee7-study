package com.cshuig.eventListener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 类名		: MyServletRequestListener
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:20:02
 * 功能描述{
 *	1、用于监听用户请求的到达
 *	2、
 * }
 * 备注信息	: 
 **/
@WebListener
public class MyServletRequestListener implements ServletRequestListener{

	/**
	 * 用户请求到达时，立即触发该方法
	 */
	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("执行：MyServletRequestListener.requestInitialized(); ");
	}
	
	/**
	 * 用户请求结束，立即触发该方法
	 */
	@Override
	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("执行：MyServletRequestListener.requestDestroyed();");
	}
}


