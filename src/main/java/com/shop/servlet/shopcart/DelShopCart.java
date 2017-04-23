package com.shop.servlet.shopcart;

import com.shop.dao.ShopCartDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

/**
 */
public class DelShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DelShopCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try{
		  String param = request.getParameter("id");
		  int id = 0 ;
		  if(param != null && param.equals("")) {
			  id = Integer.parseInt(param);
		  }
		  ShopCartDao scd = new ShopCartDao();
		  boolean isSucess = scd.delete(id);

		   //提示信息的页面
			String redirectPage = "info.jsp";
			//自动跳转目录
			String autoReturnPage ;
			//获取session
			HttpSession session = request.getSession();
			//返回的提示信息
			String msg="";
			redirectPage = "cart.jsp";
			response.sendRedirect(redirectPage);
//		  if(isSucess == true){
//			 
//		  }else{
//			  
//		  }
	  }catch(Exception e) {
		  e.printStackTrace();
	  }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
