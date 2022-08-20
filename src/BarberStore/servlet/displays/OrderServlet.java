package BarberStore.servlet.displays;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BarberStore.beans.CaLamViec;
import BarberStore.beans.DichVu;
import BarberStore.beans.KhungGio;
import BarberStore.beans.NhanVien;
import BarberStore.beans.Tiem;
import BarberStore.utils.OrderUtils;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DichVu> dsdv = OrderUtils.QueryDichVu();
		request.setAttribute("dsdv", dsdv);
		List<String> dscn = OrderUtils.QueryChiNhanh();
		request.setAttribute("dscn", dscn);
		List<KhungGio> dskg = OrderUtils.QueryKhungGio();
		request.setAttribute("dskg", dskg);
		
		//K: chi nhanh - V: danh sach cac tiem cua chi nhanh K
		Map<String, List<Tiem>> dsccn = new HashMap<String, List<Tiem>>();
		//K: tiem - V: danh sach cac nv cua tiem K
		Map<String, List<NhanVien>> dscnvtct = new HashMap<String, List<NhanVien>>();
		// Neu ko co chon nhan vien - mac dinh la tat ca nv
		// K: tiem - V: danh sach cac ca lam viec cua tat ca nhan vien trong tiem K
		Map<String, List<CaLamViec>> dscclvct = new HashMap<String, List<CaLamViec>>();
		// K: nhan vien - V: danh sach cac ca lam viec cua nhan vien K
		Map<String, List<CaLamViec>> dscclvccnv = new HashMap<String, List<CaLamViec>>();
		
		for(String chiNhanh : dscn) {
			List<Tiem> dstccn = OrderUtils.QueryTiem(chiNhanh);
			//request.setAttribute("dstccn" + dscn.indexOf(chiNhanh), dstccn);
			dsccn.put("dstccn" + dscn.indexOf(chiNhanh),dstccn);
			for(Tiem tiem : dstccn) {
				// Neu ko co chon nhan vien - mac dinh la tat ca nv
				List<CaLamViec> dsclvtt = OrderUtils.QueryCaLamViecTrongTiem(tiem.getId());
				//request.setAttribute("dsclvtt"+ tiem.getId(), dsclvtt);
				dscclvct.put("dsclvtt"+ tiem.getId(), dsclvtt);
//				List<KhungGio> dskgtt = OrderUtils.QueryKhungGioTrong(dsclvtt);
//				request.setAttribute("dskgtt"+ dstccn.indexOf(tiem), dskgtt);
				
				//Cac ca lam viec cua nhan vien
				List<NhanVien> dsnvtt = OrderUtils.QueryNhanVien(tiem.getId());
				//request.setAttribute("dsnvtt"+ tiem.getId(), dsnvtt);
				dscnvtct.put("dsnvtt" + tiem.getId(), dsnvtt);
				for(NhanVien nv :dsnvtt) {
					List<CaLamViec> dsclvcnv = OrderUtils.QueryCaLamViecCuaNhanVien(nv.getId());
					//request.setAttribute("dsclvcnv" + nv.getId(), dsclvcnv);
					dscclvccnv.put("dsclvcnv" + nv.getId(), dsclvcnv);
//					List<KhungGio> dskgcnv = OrderUtils.QueryKhungGioTrong(dsclvcnv);
//					request.setAttribute("dskgcnv"+ dsnvtt.indexOf(nv), dskgcnv);
				}
			}
		}
		request.setAttribute("dsccn", dsccn);
		request.setAttribute("dscnvtct", dscnvtct);
		request.setAttribute("dscclvct", dscclvct);
		request.setAttribute("dscclvccnv", dscclvccnv);
		
		RequestDispatcher dispatcher = this.getServletContext().
				getRequestDispatcher("/WEB-INF/views/OrderView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
