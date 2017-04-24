package com.shop.servlet.customer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.shop.dao.CustomerDao;
import com.shop.domain.Customer;
import java.io.PrintWriter;

public class CustomerLogin extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try{
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		
		CustomerDao cd = new CustomerDao();
		
		Customer c = cd.find(username, password);
        //提示信息的页面
        String redirectPage = "info.jsp";
        //自动跳转目录
        String autoReturnPage ="";
        //获取session
        HttpSession session = request.getSession();
        //返回的提示信息
        String msg="";
		if(c != null ){
		  session.setAttribute("customer", c);
		  redirectPage = "index.jsp";
		}else{
			//用户名密码不匹配
            msg = "用户名和密码不匹配";
            autoReturnPage = "login.jsp";
		}
		session.setAttribute("msg",msg);
		session.setAttribute("autoReturn",autoReturnPage);
		response.sendRedirect(redirectPage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response){
		doGet(request,response);
	}
}
