package BarberStore.servlet.displays;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.utils.UserUtils;


@WebServlet("/xoa")
public class DeleteBill extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteBill() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idhh = request.getParameter("idhh");
		UserUtils.DeleteHoaDon(idhh);
		response.sendRedirect(request.getContextPath() + "/account");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
