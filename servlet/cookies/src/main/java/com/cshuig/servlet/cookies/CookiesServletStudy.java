package com.cshuig.servlet.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名		: CookiesServletStudy
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-30 下午8:09:31
 * 功能描述{
 *	1、
 *	2、
 * }
 * 备注信息	: 
 **/
@WebServlet(urlPatterns = {"/cookiesServletStudy"})
@MultipartConfig(location = "/temp")
public class CookiesServletStudy extends HttpServlet{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么). 
	 */
	private static final long serialVersionUID = 4029326567883232925L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			out.println("<html>");
			
			out.println("<head>");
			out.println("<title>Cookies:Servelt学习</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Cookies:Servelt学习</h1>");
			SessionCookieConfig sessionCookieConfig = request.getServletContext().getSessionCookieConfig();
			out.println("找到Cookies：" + sessionCookieConfig.getName());
			
			Cookie cookie = new Cookie("newCookieKey", "newCookiesValue");
			cookie.setMaxAge(60);
			response.addCookie(cookie);
			out.println("添加一个Cookie,keyName=["+cookie.getName()+"] ,Value=["+cookie.getValue()+"] ,path=["+cookie.getPath()+"]");
			
			cookie = new Cookie("newHttpCookieKey", "newHttpCookieValue");
			cookie.setMaxAge(60);
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
			out.println("又添加一个HTTPOnlyCookie,keyName=["+cookie.getName()+"] ,Value=["+cookie.getValue()+"] ,path=["+cookie.getPath()+"]");
			
			out.println("Check what cookies are visible by");
			out.println("<a href=\"http://"+request.getServerName()+":"+request.getServerPort()+"/indexCookie.jsp\">点击查看</a>");
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
		return "执行：CookiesServletStudy.getServletInfo() ----------end----------";
	}
}


