package com.shop.servlet.kind;

import com.shop.dao.KindDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DelKind extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DelKind() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			KindDao kd = new KindDao();
			boolean delsucess = kd.delete(id);
			if(delsucess == true){
				out.println("delete kind sucess!");
			}else{
				out.println("delete kind failed!");
			}
			String stayTime = "3000";
			String URL = "listKind.jsp";
			String content=stayTime+";URL="+URL;
			response.setHeader("REFRESH",content); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
