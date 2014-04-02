Servlet中的重要对象（只针对应用） 


                	  数量                生命周期                 	 是否线程安全                          方法
-------------------------------------------------------------------------------------------------------------------------------------------                     
ServletContext        1      （天）全局的                             不安全                     setAttribute(String,Object)-->全局属性 任何Session都可以取到
                                                                             只有在应用关闭时才销毁         需要加同步访问                 Object getAttribute(String)   
                                                          void removeAttibute(String)     
-------------------------------------------------------------------------------------------------------------------------------------------                     
HttpSession        和用户的	（分/小时）局部的		       不安全		  setAttribute(String,Object)-->存储用户级的属性 
				         数量相同	  只在有效时间内存在        可以不加同步访问            Object getAttribute(String)                     
                                                          synchronized(session){......}
                                                          void removeAttibute(String) 
-------------------------------------------------------------------------------------------------------------------------------------------                     
ServletRequest       多个                 （秒）局部的               	       线程安全                    setAttribute(String,Object)  可以传递 
(HttpServletRequest)      只在servic()和doGet()             Object getAttribute(String)  大量信息 
                             doPost()中存在                                                    void removeAttibute(String)  只使用一次 
-------------------------------------------------------------------------------------------------------------------------------------------         

二、作用 
1、主要对ServletContext、HttpSession、ServletRequest等对象行为的监听 
2、必须要实现一个或多个listener interface 
3、有两类监听器：声明周期监听器  ServletContextListener             HttpSessionListener              ServletRequestListener （2.4版本之后） 
                 对象状态监听器  ServletContextAttributeListener    HttpSessionAttributeListener     ServletRequestAttributeListener 
4、ServletContextListener中不能取得请求中的参数