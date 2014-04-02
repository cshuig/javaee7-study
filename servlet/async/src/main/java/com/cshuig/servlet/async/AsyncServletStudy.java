package com.cshuig.servlet.async;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类名		: AsyncServletStudy
 * JDK版本	: JDK1.7+
 * 创  建  者	: cshuig
 * 创建时间	: 2013-12-31 下午1:22:46
 * 功能描述{
 *	1、
 *	2、
 * }
 * 备注信息	:git测试
 **/
@WebServlet(urlPatterns = "/asyncServletStudy" ,asyncSupported = true)
public class AsyncServletStudy extends HttpServlet{

	/**
	 * serialVersionUID:TODO(用一句话描述这个变量表示什么).
	 */
	private static final long serialVersionUID = 2464351807352253091L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>异步Servlet学习</title>");
			out.println("</head>");
			out.println("<body>");
			AsyncContext asyncContext = request.startAsync();

			asyncContext.addListener(new AsyncListener() {
				@Override
				public void onTimeout(AsyncEvent event) throws IOException {
					System.out.println("执行：onTimeout：");
				}

				@Override
				public void onStartAsync(AsyncEvent event) throws IOException {
					System.out.println("执行：onStartAsync：");
				}

				@Override
				public void onError(AsyncEvent event) throws IOException {
					System.out.println("执行：onError：");
				}

				@Override
				public void onComplete(AsyncEvent event) throws IOException {
					System.out.println("执行：onError：");
				}
			});
			out.println("<br><h1>开始执行异步Servlet</h1>");
			asyncContext.start(new myServletThread(asyncContext));
			out.println("</body>");
			out.println("</html>");

			//如果out未关闭，当异步线程执行完成后，调用：asyncContext.complete() 会报如下错误：
			//	java.lang.IllegalStateException: IDLE,initial
			out.flush();
			out.close();
		}

	}

	class myServletThread implements Runnable{

		AsyncContext asyncContext ;
		public myServletThread(AsyncContext _asyncContext){
			this.asyncContext = _asyncContext;
		}
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				System.out.println("我是线程，3秒已过，开始执行....");
				System.out.println(asyncContext.getTimeout());
				asyncContext.complete();
				System.out.println("11");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

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
		return "执行：AsyncServletStudy.getServletInfo()";
	}
}


