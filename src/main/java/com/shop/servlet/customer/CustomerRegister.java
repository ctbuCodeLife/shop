package com.shop.servlet.customer;

import com.shop.dao.CustomerDao;
import com.shop.domain.Customer;
import com.shop.utils.DBUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class CustomerRegister extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String tel = request.getParameter("tel");

			CustomerDao cd = new CustomerDao();

			//提示信息的页面
			String redirectPage = "info.jsp";
			//自动跳转目录
			String autoReturnPage ="index.jsp";
			//获取session
			HttpSession session = request.getSession();
			//返回的提示信息
			String msg="";

			String sql = "insert into customer(username,password,tel,sex)values(?,?,?,?)";
			Object[] params = { username, password, tel, "保密" };
			DBUtil db = new DBUtil();
			int n = db.doUpdate(sql, params);
			System.out.println(n);
			if (n > 0) {
				//注册成功
				msg = "注册成功,3秒钟自动跳转到登录页面";
				autoReturnPage = "login.jsp";
			} else {
				//注册失败,该用户已存在
				msg = "注册失败,用户名已存在!!3秒后自动跳转到注册页面";
				autoReturnPage = "register.jsp";
			}
			session.setAttribute("msg",msg);
			session.setAttribute("autoReturn",autoReturnPage);
			response.sendRedirect(redirectPage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
