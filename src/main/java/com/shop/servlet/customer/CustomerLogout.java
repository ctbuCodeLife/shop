package com.shop.servlet.customer;

import com.shop.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CustomerLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CustomerLogout() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        	HttpSession session = request.getSession();
        	Customer c = (Customer)session.getAttribute("customer");
        
        	if(c != null){
        		session.removeAttribute("customer");
        	}
        	response.sendRedirect("index.jsp");
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
