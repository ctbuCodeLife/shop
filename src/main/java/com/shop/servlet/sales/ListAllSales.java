package com.shop.servlet.sales;

import com.shop.domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "ListAllSales",urlPatterns = "/ListAllSales")
public class ListAllSales extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            //提示信息的页面
            String redirectPage = "info.jsp";
            //自动跳转目录
            String autoReturnPage = "index.jsp";//重定向页面自动跳转的页面,默认为首页
            String msg = ""; //返回的提示信息
            //获取session
            HttpSession session = request.getSession();
            //获取用户
            Customer customer = (Customer) session.getAttribute("customer");
            if (customer == null) {
                //未登录;
                msg = "您还没有登录沃,请登录后再查看订单.3秒后自动跳转到主页.";
                autoReturnPage = "login.jsp";
            } else {
                //用户已登录
                int cid = customer.getId();
                //获取请求参数
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
