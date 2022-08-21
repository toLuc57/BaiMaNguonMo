package BarberStore.servlet.displays;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.HoaDon;
import BarberStore.beans.KhachHang;
import BarberStore.utils.MyUtils;
import BarberStore.utils.UserUtils;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idKhachHang = MyUtils.getLoginedUser(request.getSession()).getId();
		List<HoaDon> dshdcht = UserUtils.QueryHoaDonChuaHoanThanh(idKhachHang);
		request.setAttribute("dshdcht", dshdcht);
		List<HoaDon> dshddht = UserUtils.QueryHoaDonDaHoanThanh(idKhachHang);
		request.setAttribute("dshddht", dshddht);
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String hoTen = request.getParameter("hoTen");
		String sdt = request.getParameter("sdt");
		String matKhau = request.getParameter("matKhau");
		
		System.out.println("AccountServlet.doPost");
		
		KhachHang kh = new KhachHang(id, hoTen, sdt, matKhau);
		UserUtils.UpdateThongTinKhach(kh);
		
		MyUtils.storeLoginedUser(request.getSession(), kh);
		response.sendRedirect(request.getContextPath() + "/");
	}

}
