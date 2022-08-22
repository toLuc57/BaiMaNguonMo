package BarberStore.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import BarberStore.utils.UserUtils;

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
		List<String> requiredPages = new ArrayList<String>();
		requiredPages.add("/BarberStore/xoa");
		requiredPages.add("/BarberStore/account");
		requiredPages.add("/BarberStore/order");
		requiredPages.add("/BarberStore/chitiet");
		if(loginedUser == null) {
			if(requiredPages.contains(req.getRequestURI())) {
				resp.sendRedirect(req.getContextPath() + "/");
				return;
			}
			// req.getRequestURI() la cac trang ko yeu cau dang nhap
			else {
				String sdt = request.getParameter("phone");
				String mk = request.getParameter("password");
				
				if(sdt == null || sdt.length() == 0) {
					MyUtils.deleteLoginedUser(req.getSession());
					chain.doFilter(request, response);
					return;
				}
				else {
					KhachHang kh = UserUtils.QueryKhachHang(sdt, mk);
					if(kh == null) {
						MyUtils.deleteLoginedUser(req.getSession());
						request.setAttribute("ttdn","Fail");
					}
					else {
						request.setAttribute("ttdn", null);
					}
					MyUtils.storeLoginedUser(req.getSession(), kh);
				}
			}
		}
		else {
			request.setAttribute("loginedUser", loginedUser);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
