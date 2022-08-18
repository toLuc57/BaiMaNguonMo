package BarberStore.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.KhachHang;
import BarberStore.utils.MyUtils;

@WebFilter(filterName="LoginedFilter", urlPatterns= {"/*"})
public class LoginedFilter implements Filter {


    public LoginedFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		KhachHang loginedUser = MyUtils.getLoginedUser(req.getSession());
		if(loginedUser == null) {
			//System.out.println(req.getRequestURI());
			if(!req.getRequestURI().equals("/BarberStore/")) {
				resp.sendRedirect(req.getContextPath() + "/");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
