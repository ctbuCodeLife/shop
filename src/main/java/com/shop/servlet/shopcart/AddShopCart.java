package com.shop.servlet.shopcart;

import com.shop.dao.ProductDao;
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
		try{
			PrintWriter out = response.getWriter();
			int id = 0;
			String cid = request.getParameter("cId");
			int pId = Integer.parseInt(request.getParameter("pId"));
			int count = Integer.parseInt(request.getParameter("count"));
			String isBuy = request.getParameter("isBuy");
			
			//计算总价
			BigDecimal totolPrice ;
			BigDecimal unitPrice;//商品单价
			ProductDao pd = new ProductDao();
			Product p = new Product();
			p = pd.find(pId);
			unitPrice = p.getiPrice();
			totolPrice = unitPrice.multiply(new BigDecimal(Integer.valueOf(count)));
			//将porduct设置到session中
            request.getSession().setAttribute("product", p);
			//提示信息的页面
			String redirectPage = "info.jsp";
			//自动跳转目录
			String autoReturnPage ;
			//获取session
			HttpSession session = request.getSession();
			//返回的提示信息
			String msg;

			int cId = 0;//用户未登录时设置购物车id为0，cId为0
			if(cid != null || cid.equals("")){
				//用户已登录
				cId = Integer.parseInt(cid);
				DBUtil db = new DBUtil();
				String sql = "insert into shopcart(cId,pId,count,isBuy,totalPrice) values(?,?,?,?,?)";
				Object[] params = {cId,pId,count,isBuy,totolPrice};
				int n = db.doUpdate(sql, params);
				if(n > 0){
					//添加购物车成功
					msg = "添加购物车成功,3秒后自动跳转到商品页面.";
				}else {
					//添加购物车失败
                    msg = "添加购物车成功,3秒后自动跳转到商品页面.";
				}
			}else {
			    //添加到sesson中
			    ShopCart sc = new ShopCart();
			    sc.setId(id);
			    sc.setcId(cId);
			    sc.setpId(pId);
			    sc.setCount(count);
			    sc.setIsBuy(isBuy);
			    sc.setTotolPrice(totolPrice);
			    session.setAttribute("shopcart", sc);
                msg = "添加购物车成功,3秒后自动跳转到商品页面.";
			}
            autoReturnPage = "product_info.jsp?id="+pId;
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
