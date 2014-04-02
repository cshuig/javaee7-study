package com.cshuig.eventListener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 类名		: ServletListenerStudy
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午9:44:51
 * 功能描述{
 *	1、
 *	2、
 * }
 * 备注信息	: 
 **/
@WebServlet(urlPatterns = "/servletListenerStudy")
public class ServletListenerStudy extends HttpServlet{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = -3348897780543313355L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYEP html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>ServletListener:学习</title>");
			out.println("</head>");
			out.println("<body>");
			
			out.println("<h1>ServletListener:学习</h1>");
			//设置全局共享区域的属性
			ServletContext servletContext = request.getServletContext();
			//添加
			servletContext.setAttribute("servletContextAttribute-key", "servletContextAttribute-add");
			//修改
			servletContext.setAttribute("servletContextAttribute-key", "servletContextAttribute-replaced");
			//移除
			servletContext.removeAttribute("servletContextAttribute-key");
			out.println("done:全局共享区域的属性操作完成，看后台输出信息。。。<br>");
			
			//设置HttpSession属性
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("httpSession-key", "httpSession-add");
			httpSession.setAttribute("httpSession-key", "httpSession-replaced");
			httpSession.removeAttribute("httpSession-key");
			out.println("done:设置HttpSession属性操作完成，看后台输出信息。。。<br>");
			
			//设置Request范围的属性
			request.setAttribute("requestAttribute-key", "requestAttribute-add");
			request.setAttribute("requestAttribute-key", "requestAttribute-replaced");
			request.removeAttribute("requestAttribute-key");
			out.println("done:设置Request范围的属性操作完成，看后台输出信息。。。<br>");
			
			request.getSession().invalidate();
	        out.println("done");
	        out.println("<br><br>Check output in server log");
	        
			out.println("</body>");
			out.println("</html>");
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	public String getServletInfo() {
		return "执行：ServletListenerStudy.getServletInfo();";
	}
}


