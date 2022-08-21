package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BarberStore.beans.CaLamViec;
import BarberStore.beans.DichVu;
import BarberStore.beans.KhungGio;
import BarberStore.beans.NhanVien;
import BarberStore.beans.Tiem;
import BarberStore.jdbc.MySQLConnUtils;

public class OrderUtils {	
	private static Map<String,String> mapGioBatDau = new HashMap<String, String>();
	private static Map<String,Integer> mapDichVu = new HashMap<String, Integer>();
	
	public static List<DichVu> QueryDichVu() {
		Connection conn = null;
		List<DichVu> list = new ArrayList<DichVu>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from dich_vu");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String id = rs.getString("dich_vu_id");
            	String ten = rs.getString("ten_dich_vu");
            	int gia = rs.getInt("gia");
            	String ghiChu = rs.getString("ghi_chu");
            	
            	DichVu caLamViec = new DichVu(id, ten, gia, ghiChu);
            	list.add(caLamViec);
            	mapDichVu.put(id,gia);
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
            	String batDau = rs.getString("bat_dau");
            	String ketThuc = rs.getString("ket_thuc");
            	
            	KhungGio khungGio = new KhungGio(id,batDau,ketThuc);
            	list.add(khungGio);
            	mapGioBatDau.put(id,batDau);
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
            		" where nhan_vien_id in (select nhan_vien_id from nhan_vien" + 
            		" where tiem_id = ? and trang_thai = 1) and trang_thai= 0");
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
	
	private static void UpdateCaLamViec(String idNhanVien, String idKhungGio, String ngayDat) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String update = "update ca_lam_viec "
					+ " SET trang_thai = 1 "
					+ " WHERE nhan_vien_id = ? and khung_gio_id = ? "
					+ " and ngay_lam_viec = ?";
			PreparedStatement pstm = conn.prepareStatement(update);
			pstm.setString(1, idNhanVien);
			pstm.setString(2, idKhungGio);
			pstm.setString(3, ngayDat);
			System.out.println("OrderUtils.UpdateCaLamViec:" +pstm.executeUpdate());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void InsertChiTietHoaDon(String idKhachHang, String ngayDat,
			 String idNhanVien,String[] cacDichVu) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String query = "SELECT hoa_don_id FROM hoa_don" + 
					" where khach_hang_id = ? " + 
					" and ngay_thuc_hien = ? " + 
					" and nhan_vien_id = ? " + 
					" and NOT EXISTS (select 1 from chi_tiet_hoa_don " + 
					"	where hoa_don.hoa_don_id = chi_tiet_hoa_don.hoa_don_id)";
			PreparedStatement pstm = conn.prepareStatement(query);
			pstm.setString(1, idKhachHang);
			pstm.setString(2, ngayDat);
			pstm.setString(3, idNhanVien);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				String idHoaDon = rs.getString("hoa_don_id");
				String insert = "INSERT INTO chi_tiet_hoa_don (hoa_don_id, dich_vu_id, gia_ca)"
						+ " VALUES (?, ?, ?)";
				for(int i = 0; i< cacDichVu.length;++i) {
					String idDichVu = cacDichVu[i];
					int gia = mapDichVu.get(idDichVu);
					PreparedStatement pstm1 = conn.prepareStatement(insert);
					pstm1.setString(1, idHoaDon);
					pstm1.setString(2, idDichVu);
					pstm1.setInt(3, gia);	
					pstm1.executeUpdate();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
	}
	
	private static void InsertHoaDon(String idKhachHang, String ngayDat,
			String idNhanVien, String[] cacDichVu) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String update = "INSERT INTO hoa_don (khach_hang_id, ngay_thuc_hien, nhan_vien_id)"
					+ " VALUES (?, ?, ?)";
			PreparedStatement pstm = conn.prepareStatement(update);
			pstm.setString(1, idKhachHang);
			pstm.setString(2, ngayDat);
			pstm.setString(3, idNhanVien);
			pstm.executeUpdate();
			OrderUtils.InsertChiTietHoaDon(idKhachHang, ngayDat, idNhanVien,cacDichVu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
	}
	
	public static void DatLich(String idKhachHang, String idNhanVien, 
			String idKhungGio, String ngayDat, String[] cacDichVu, String idTiem) {
		OrderUtils.UpdateCaLamViec(idNhanVien, idKhungGio, ngayDat);
		ngayDat = ngayDat + " " + mapGioBatDau.get(idKhungGio);
		OrderUtils.InsertHoaDon(idKhachHang, ngayDat, idNhanVien, cacDichVu);
	}
}
