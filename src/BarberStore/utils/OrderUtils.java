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
import BarberStore.beans.NhanVien;
import BarberStore.beans.Tiem;
import BarberStore.jdbc.MySQLConnUtils;

public class OrderUtils {
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
	
	public static List<String> QueryChiNhanh() {
		Connection conn = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select quan from tiem group by quan");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String quan = rs.getString("quan");
            	list.add(quan);
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
	
	public static List<Tiem> QueryTiem(String chiNhanh) {
		Connection conn = null;
		List<Tiem> list = new ArrayList<Tiem>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from tiem where quan=?");
            pstm.setString(1, chiNhanh);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("tiem_id");
            	String ten = rs.getString("ten_tiem");
            	String dienThoai = rs.getString("dien_thoai");
            	String duong = rs.getString("ten_duong");
            	String phuong = rs.getString("phuong");
            	String quan = rs.getString("quan");
            	
            	Tiem caLamViec = new Tiem(id, ten, dienThoai, duong, phuong, quan);
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
	
	public static List<NhanVien> QueryNhanVien(String idTiem) {
		Connection conn = null;
		List<NhanVien> list = new ArrayList<NhanVien>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from nhan_vien where tiem_id = ? and trang_thai = 1");
            pstm.setInt(1, Integer.parseInt(idTiem));
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("nhan_vien_id");
            	String hoTen = rs.getString("ho_ten");
            	String dienThoai = rs.getString("dien_thoai");
            	String cmnd = rs.getString("CMND");
            	String trangThai = rs.getString("trang_thai");
            	String idTiemHang = rs.getString("tiem_id");
            	String idTruongCa = rs.getString("truong_ca_id");
            	
            	NhanVien caLamViec = new NhanVien(idNhanVien, hoTen, dienThoai, cmnd, trangThai, idTiemHang, idTruongCa);
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
	
	public static List<KhungGio> QueryKhungGio() {
		Connection conn = null;
		List<KhungGio> list = new ArrayList<KhungGio>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select * from khung_gio");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("bat_dau").toString();
            	String ketThuc = rs.getDate("ket_thuc").toString();
            	
            	KhungGio khungGio = new KhungGio(id,batDau,ketThuc);
            	list.add(khungGio);
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
	
	public static List<CaLamViec> QueryCaLamViecTrongTiem(String idTiem) {
		Connection conn = null;
		List<CaLamViec> list = new ArrayList<CaLamViec>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select * from ca_lam_viec" + 
            		" where nhan_vien_id in (select nhan_vien_id from tiem" + 
            		" where tiem_id = ? and trang_thai = 1) and trang_thai=0");
            pstm.setString(1, idTiem);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("nhan_vien_id");
            	String idKhungGio = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("ngay_lam_viec").toString();
            	int trangThai = rs.getInt("trang_thai");
            	
            	CaLamViec caLamViec = new CaLamViec(idNhanVien,idKhungGio,batDau,trangThai);
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
	
	public static List<CaLamViec> QueryCaLamViecCuaNhanVien(String idNhanVien) {
		Connection conn = null;
		List<CaLamViec> list = new ArrayList<CaLamViec>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from ca_lam_viec "
            		+ "where nhan_vien_id=? and trang_thai=0");
            pstm.setString(1, idNhanVien);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNV = rs.getString("nhan_vien_id");
            	String idKhungGio = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("ngay_lam_viec").toString();
            	int trangThai = rs.getInt("trang_thai");
            	
            	CaLamViec caLamViec = new CaLamViec(idNV,idKhungGio,batDau,trangThai);
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
	
	public static List<KhungGio> QueryKhungGioTrong(List<CaLamViec> dsCaLamViec) {
		if(dsCaLamViec.isEmpty() || dsCaLamViec.size() ==0) {
			return null;
		}
		Connection conn = null;
		List<KhungGio> list = new ArrayList<KhungGio>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
			String query ="select * from khung_gio"
					+ " where khung_gio_id in (" + dsCaLamViec.get(0).getIdKhungGio();
			for(int i = 1; i < dsCaLamViec.size(); ++i) {
				query = query.concat(", " +dsCaLamViec.get(i).getIdKhungGio());
				
			}
			query = query.concat(")");
			
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("khung_gio_id");
            	String batDau = rs.getDate("bat_dau").toString();
            	String ketThuc = rs.getDate("ket_thuc").toString();
            	
            	KhungGio khungGio = new KhungGio(id,batDau,ketThuc);
            	list.add(khungGio);
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
