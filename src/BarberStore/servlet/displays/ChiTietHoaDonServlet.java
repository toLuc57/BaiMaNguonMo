package BarberStore.servlet.displays;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.ChiTietHoaDon;
import BarberStore.utils.UserUtils;

/**
 * Servlet implementation class ChiTietHoaDonServlet
 */
@WebServlet("/chitiet")
public class ChiTietHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ChiTietHoaDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idhh = request.getParameter("idhh");
		List<ChiTietHoaDon> cthd = UserUtils.QueryChiTietHoaDon(idhh);
		request.setAttribute("cthd", cthd);
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/billView.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
