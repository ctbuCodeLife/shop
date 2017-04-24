package com.shop.servlet.shopcart;

import com.shop.dao.ProductDao;
import com.shop.domain.Customer;
import com.shop.utils.DBUtil;
import com.shop.domain.Product;
import com.shop.domain.ShopCart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class AddShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddShopCart() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            //提示信息的页面
            String redirectPage = "info.jsp";
            //自动跳转目录
            String autoReturnPage = "";
            //返回的提示信息
            String msg = "";
            //获取session
            HttpSession session = request.getSession();
            Customer c = (Customer) session.getAttribute("customer");
            if (c == null) {
                //未登录;
                msg = "您还没有登录沃,请登录后再添加购物车吧.";
                autoReturnPage = "login.jsp";
            } else {
                //用户已登录
                int cid = c.getId();
                int pId = Integer.parseInt(request.getParameter("pId"));
                int count = Integer.parseInt(request.getParameter("count"));
                String isBuy = request.getParameter("isBuy");

                //计算总价
                BigDecimal totolPrice;
                BigDecimal unitPrice;//商品单价
                ProductDao pd = new ProductDao();
                Product p = new Product();
                p = pd.find(pId);
                unitPrice = p.getiPrice();
                totolPrice = unitPrice.multiply(new BigDecimal(Integer.valueOf(count)));
                //将porduct设置到session中
                request.getSession().setAttribute("product", p);

                DBUtil db = new DBUtil();
                String sql = "insert into shopcart(cId,pId,count,isBuy,totalPrice) values(?,?,?,?,?)";
                Object[] params = {cid, pId, count, isBuy, totolPrice};
                int n = db.doUpdate(sql, params);
                if (n == 1) {
                    //添加购物车成功
                    msg = "添加购物车成功,3秒后自动跳转到商品页面.";

                } else {
                    //添加购物车失败
                    msg = "添加购物车成功,3秒后自动跳转到商品页面.";
                }
                autoReturnPage = "product_info.jsp?id=" + pId;
            }
            
			session.setAttribute("msg",msg);
			session.setAttribute("autoReturn",autoReturnPage);
			response.sendRedirect(redirectPage);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
