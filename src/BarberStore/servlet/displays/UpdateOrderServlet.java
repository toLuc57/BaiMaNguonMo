package BarberStore.servlet.displays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.CaLamViec;
import BarberStore.beans.KhungGio;
import BarberStore.utils.OrderUtils;
import BarberStore.utils.UserUtils;

@WebServlet("/update")
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateOrderServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String idhh = request.getParameter("idhh");
		String idnv = request.getParameter("idnv");
		
		String orderDate = request.getParameter("order").split(" ")[0];
		List<CaLamViec> listCLV = OrderUtils.QueryCaLamViecCuaNhanVien(idnv,orderDate); 
		List<KhungGio> listKG = new ArrayList<KhungGio>();
		for(CaLamViec caLam: listCLV) {
			listKG.add(OrderUtils.QueryKhungGio(caLam.getIdKhungGio()));
		}
		
		request.setAttribute("idhh", idhh);
		request.setAttribute("dskg", listKG);
		request.setAttribute("orderDate", orderDate);
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/updateOrder.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idhh = request.getParameter("idhh");
		String orderDate = request.getParameter("orderDate");
		String shift = request.getParameter("shift");
		orderDate = orderDate + " " + shift;

		UserUtils.ChangeLich(idhh, orderDate);
		response.sendRedirect(request.getContextPath() + "/account");
	}

}
