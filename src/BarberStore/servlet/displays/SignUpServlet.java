package BarberStore.servlet.displays;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.KhachHang;
import BarberStore.utils.MyUtils;
import BarberStore.utils.UserUtils;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/signUpView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String hoTen = request.getParameter("hoTen");
		String sdt = request.getParameter("sdt");
		String matKhau = request.getParameter("matKhau");
		
		KhachHang kh = new KhachHang("", hoTen, sdt, matKhau);
		
		MyUtils.storeLoginedUser(request.getSession(), UserUtils.InsertKhachHang(kh));
		response.sendRedirect(request.getContextPath() + "/account");
	}

}
