package com.shop.servlet.search;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.shop.dao.ProductDao;
import com.shop.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "searchByNameServlet",urlPatterns = "/searchByName")
public class searchByNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            ProductDao pd = new ProductDao();
            String paramName = request.getParameter("name");
            Product pt= pd.find(paramName);
            PrintWriter out = response.getWriter();
            response.setCharacterEncoding("UTF-8");
            //将list的数据转换成JSON返回给前台
            //JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
            //SerializerFeature.WriteDateUseDateFormat用来将日期格式化成yyyy-MM-dd的形式
            String json = JSON.toJSONString(pt, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect);
            if (pt != null) {
                out.println(json);
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
