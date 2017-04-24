package com.shop.filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CharSetFilter implements Filter {
    private String myEncoding;
   
    public CharSetFilter() {
    }

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;

    	req.setCharacterEncoding(myEncoding);
		resp.setCharacterEncoding(myEncoding);

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//从web.xml文件读取默认编码
		this.myEncoding = fConfig.getInitParameter("initEncoding");
	}

}
