package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BarberStore.beans.CaLamViec;
import BarberStore.beans.DichVu;
import BarberStore.beans.KhungGio;
import BarberStore.jdbc.MySQLConnUtils;

public class OrderUtils {
	private static final String QUERY_KHUNG_GIO_TRONG = "select * from khung_gio"
			+ " where khung_gio_id in (select khung_gio_id from ca_lam_viec"
			+ " where trang_thai = 0)";
	private static final String QUERY_CA_LAM = "select * from ca_lam_viec"
			+ " where trang_thai = 0";
	
	public static List<KhungGio> QueryKhungGioTrong() {
		Connection conn = null;
		List<KhungGio> danhSachKhungGioTrong = new ArrayList<KhungGio>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement(QUERY_KHUNG_GIO_TRONG);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("bat_dau").toString();
            	String ketThuc = rs.getDate("ket_thuc").toString();
            	
            	KhungGio khungGio = new KhungGio(id,batDau,ketThuc);
            	danhSachKhungGioTrong.add(khungGio);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return danhSachKhungGioTrong;
	}
	public static List<KhungGio> QueryKhungGioTrong(List<String> idCuaHang) {
		if(idCuaHang.size() == 0) {
			return QueryKhungGioTrong();
		}
		Connection conn = null;
		List<KhungGio> danhSachKhungGioTrong = new ArrayList<KhungGio>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
			String queryThemDK ="select nhan_vien_id from nhan_vien"
					+ " where trang_thai = 1 and store_id in (" + idCuaHang.get(0);
			for(int i = 1; i < idCuaHang.size(); ++i) {
				queryThemDK = queryThemDK.concat(", idCuaHang");
				
			}
			queryThemDK = queryThemDK.concat(",)");
			String query = QUERY_KHUNG_GIO_TRONG + " and nhan_vien_id in (" + queryThemDK + ")";
			
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("bat_dau").toString();
            	String ketThuc = rs.getDate("ket_thuc").toString();
            	
            	KhungGio khungGio = new KhungGio(id,batDau,ketThuc);
            	danhSachKhungGioTrong.add(khungGio);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return danhSachKhungGioTrong;
	}
	
	public static List<CaLamViec> QueryCaLamViecTrong() {
		Connection conn = null;
		List<CaLamViec> danhSachCaLamTrong = new ArrayList<CaLamViec>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement(QUERY_CA_LAM);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("nhan_vien_id");
            	String idKhungGio = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("ngay_lam_viec").toString();
            	int trangThai = rs.getInt("trang_thai");
            	
            	CaLamViec caLamViec = new CaLamViec(idNhanVien,idKhungGio,batDau,trangThai);
            	danhSachCaLamTrong.add(caLamViec);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return danhSachCaLamTrong;
	}
	
	public static List<CaLamViec> QueryCaLamViecTrong(List<String> idCuaHang) {
		if(idCuaHang.size() == 0) {
			return QueryCaLamViecTrong();
		}
		Connection conn = null;
		List<CaLamViec> danhSachCaLamTrong = new ArrayList<CaLamViec>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
			String queryThemDK ="select nhan_vien_id from nhan_vien"
					+ " where trang_thai = 1 and store_id in (" + idCuaHang.get(0);
			for(int i = 1; i < idCuaHang.size(); ++i) {
				queryThemDK = queryThemDK.concat(", idCuaHang");
				
			}
			queryThemDK = queryThemDK.concat(",)");
			
			String query = QUERY_CA_LAM + " and nhan_vien_id in (" + queryThemDK + ")";
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("nhan_vien_id");
            	String idKhungGio = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("ngay_lam_viec").toString();
            	int trangThai = rs.getInt("trang_thai");
            	
            	CaLamViec caLamViec = new CaLamViec(idNhanVien,idKhungGio,batDau,trangThai);
            	danhSachCaLamTrong.add(caLamViec);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return danhSachCaLamTrong;
	}
	
	public static List<DichVu> QueryDichVu() {
		Connection conn = null;
		List<DichVu> list = new ArrayList<DichVu>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from dich_vu");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("dich_vu_id");
            	String ten = rs.getString("ten_dich_vu");
            	int gia = rs.getInt("gia");
            	String ghiChu = rs.getString("ghi_chu");
            	
            	DichVu caLamViec = new DichVu(idNhanVien, ten, gia, ghiChu);
            	list.add(caLamViec);
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return list;
	}
}
