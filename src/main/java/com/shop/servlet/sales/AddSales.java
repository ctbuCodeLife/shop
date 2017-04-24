package com.shop.servlet.sales;

import com.shop.dao.ProductDao;
import com.shop.dao.SalesDao;
import com.shop.dao.ShopCartDao;
import com.shop.domain.Customer;
import com.shop.domain.Product;
import com.shop.domain.Sales;
import com.shop.domain.ShopCart;
import sun.rmi.server.InactiveGroupException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;


@WebServlet(name = "AddSales",urlPatterns = "/AddSales")
public class AddSales extends HttpServlet {
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
                msg = "您还没有登录沃,请登录后再添加购物车吧.3秒后自动跳转到主页.";
                autoReturnPage = "login.jsp";
            } else {
                //用户已登录
                int cid = customer.getId();
                //获取请求参数
                String pidParam = request.getParameter("pid");
                String countParam = request.getParameter("count");

                if(pidParam == null ||countParam == null){
                    //没有输入 跳转到info页面提示
                    msg = "请求参数错误,3秒后自动跳转到首页.";
                    autoReturnPage = "index.jsp";
                }else{
                    //获取商品id
                    int pid = Integer.parseInt(pidParam);
                    //获取商品数量
                    int count = Integer.parseInt(countParam);
                    //获取商品
                    ProductDao pd = new ProductDao();
                    Product product = pd.find(pid);
                    if(product == null){
                        //获取商品失败
                        msg = "没有该商品信息,3秒后自动跳转到首页.";
                        autoReturnPage = "index.jsp";
                    }

                    //查询到商品后计算价格
                    BigDecimal totalPrice;
                    BigDecimal unitPrice;//商品单价
                    unitPrice = product.getiPrice();
                    totalPrice = unitPrice.multiply(new BigDecimal(Integer.valueOf(count)));

                    Timestamp orderDate = new Timestamp(System.currentTimeMillis());//下单时间
                    String invoiceNO = String.valueOf(System.currentTimeMillis());//订单流水号
                    String orderStatus = "已提交";//订单状态

                    //设置sales对象
                    Sales sales = new Sales();
                    sales.setcId(customer.getId());
                    sales.setpId(pid);
                    sales.setCount(count);
                    sales.setTotalPrice(totalPrice);
                    sales.setOrderDate(orderDate);
                    sales.setInvoiceNo(invoiceNO);
                    sales.setOrderStatus(orderStatus);

                    //插入到sales表
                    SalesDao sd = new SalesDao();
                    boolean result = sd.insert(sales);
                    if(result == true){
                        //插入成功,要删除购物车
                        msg = "下单成功,3秒后自动跳转到订单页面.";
                        autoReturnPage = "order_list.jsp";
                        //查找购物车
                        ShopCartDao scd = new ShopCartDao();
                        ShopCart shopCart = scd.find(cid,pid);
                        scd.delete(shopCart.getId());
                    }else {
                        //插入失败
                        msg = "提交失败,3秒后自动跳转到购物车页面.";
                        autoReturnPage = "cart.jsp";
                    }

                }
                session.setAttribute("msg",msg);
                session.setAttribute("autoReturn",autoReturnPage);
                response.sendRedirect(redirectPage);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
