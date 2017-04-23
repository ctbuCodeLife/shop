package com.shop.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharSetFilter implements Filter {
    private String myEncoding;
   
    public CharSetFilter() {
    }

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(myEncoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//从web.xml文件读取默认编码
		this.myEncoding = fConfig.getInitParameter("initEncoding");
	}

}
