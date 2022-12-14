package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BarberStore.beans.ChiTietHoaDon;
import BarberStore.beans.HoaDon;
import BarberStore.beans.KhachHang;
import BarberStore.beans.NhanVien;
import BarberStore.jdbc.MySQLConnUtils;

public class UserUtils {
	
	public static KhachHang QueryKhachHang(String dienThoai, String matKhau) {
		Connection conn = null;
		String newID = "";
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from khach_hang where dien_thoai=?");
            pstm.setString(1,dienThoai);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
            	PreparedStatement pstm1 = conn.prepareStatement("select *from khach_hang "
        		 		+ "where dien_thoai=? and mat_khau=?");
        		 pstm1.setString(1,dienThoai);
        		 pstm1.setString(2,matKhau);
        		 ResultSet rs1 = pstm1.executeQuery();
        		 if(rs1.next()) {
        			 String id = rs.getString("khach_hang_id");
        			 String ten = rs.getString("ho_ten");
        			 String sdt = rs.getString("dien_thoai");
        			 String mk = rs.getString("mat_khau");
        			 
        			 KhachHang kh = new KhachHang(id,ten,sdt, mk);
        			 return kh;
        		 }
        		 return null;
            }
            else {
            	String tenMacDinh = "User";
            	try {
        			String sql = "insert into khach_hang "
        					+ " (ho_ten, dien_thoai, mat_khau)"
        					+ " values (?,?,?)" ;
        			
        			PreparedStatement pstm1 = conn.prepareStatement(sql);
        			pstm1.setString(1, tenMacDinh);
        			pstm1.setString(2, dienThoai);
        			pstm1.setString(3, matKhau);
        			pstm1.executeUpdate();
        			
        			String newIdQuery = "select khach_hang_id from khach_hang where dien_thoai=?";
        			PreparedStatement pstm2 = conn.prepareStatement(newIdQuery);
        			pstm2.setString(1, dienThoai);
        			ResultSet rs2 = pstm2.executeQuery();
        			if(rs2.next()) {
        				newID = rs2.getString("khach_hang_id");
        			}
        		}
        		catch(SQLException e) {
        			MySQLConnUtils.rollbackQuietly(conn); 
        			e.printStackTrace();
        		}
            	return new KhachHang(newID,tenMacDinh,dienThoai, matKhau);
            }
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        	MySQLConnUtils.rollbackQuietly(conn);
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return null;
	}
	
	public static List<HoaDon> QueryHoaDonChuaHoanThanh(String idKhachHang){
		Connection conn = null;
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String query = "select *from hoa_don where trang_thai=1 and khach_hang_id=?";
			PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,idKhachHang);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idHoaDon = rs.getString("hoa_don_id");
            	String idKH = rs.getString("khach_hang_id");
            	String trangThai = rs.getString("trang_thai");
            	String ngayDat = rs.getString("ngay_dat");
            	String ngayThucHien = rs.getString("ngay_thuc_hien");
            	String idNhanVien = rs.getString("nhan_vien_id");
            	
            	HoaDon hd = new HoaDon(idHoaDon,idKH,trangThai,
            			ngayDat,ngayThucHien,idNhanVien);
            	list.add(hd);
            }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<HoaDon> QueryHoaDonDaHoanThanh(String idKhachHang){
		Connection conn = null;
		List<HoaDon> list = new ArrayList<HoaDon>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String query = "select *from hoa_don where trang_thai=2 and khach_hang_id=?";
			PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,idKhachHang);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idHoaDon = rs.getString("hoa_don_id");
            	String idKH = rs.getString("khach_hang_id");
            	String trangThai = rs.getString("trang_thai");
            	String ngayDat = rs.getString("ngay_dat");
            	String ngayThucHien = rs.getString("ngay_thuc_hien");
            	String idNhanVien = rs.getString("nhan_vien_id");
            	
            	HoaDon hd = new HoaDon(idHoaDon,idKH,trangThai,
            			ngayDat,ngayThucHien,idNhanVien);
            	list.add(hd);
            }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static List<ChiTietHoaDon> QueryChiTietHoaDon(String idHoaDon){
		Connection conn = null;
		List<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			String query = "select *from chi_tiet_hoa_don where hoa_don_id=?";
			PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,idHoaDon);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idHH = rs.getString("hoa_don_id");
            	String idDV = rs.getString("dich_vu_id");
            	String danhGia = rs.getString("danh_gia");
            	int gia = rs.getInt("gia_ca");

            	ChiTietHoaDon hd = new ChiTietHoaDon(idHH, idDV, danhGia, gia);
            	list.add(hd);
            }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public static void UpdateThongTinKhach(KhachHang kh) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();

			String query = "UPDATE khach_hang"
					+ " SET ho_ten=?,"
					+ " dien_thoai=?,"
					+ " mat_khau=? "
					+ "WHERE khach_hang_id = ?";
			PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setString(1,kh.getTen());
            pstm.setString(2,kh.getDienThoai());
            pstm.setString(3,kh.getMatKhau());
            pstm.setString(4,kh.getId());
            pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
	}
	private static void UpdateCaLamViec(String idHoaDon) {
		Connection conn = null;
		try {
			// Tim kiem va cap nhat lai trang thai
			String ngayDat = "";
			String gioDat = "";
			String idNhanVien = "";
			String idKhungGio= "";
			conn = MySQLConnUtils.getMySQLConUtils();
			String query1 = "SELECT nhan_vien_id, " + 
					"DATE(ngay_thuc_hien) as 'chi_ngay', " + 
					"TIME(ngay_thuc_hien) as 'chi_gio' " + 
					" FROM hoa_don WHERE hoa_don_id = ?";
			PreparedStatement pstmQuery1 = conn.prepareStatement(query1);
			pstmQuery1.setString(1, idHoaDon);
			ResultSet rs1 = pstmQuery1.executeQuery();
			if(rs1.next()) {				
				idNhanVien = rs1.getString("nhan_vien_id");
				ngayDat = rs1.getString("chi_ngay");
				gioDat = rs1.getString("chi_gio");
				
				String query2 = "SELECT khung_gio_id FROM khung_gio " + 
						"WHERE bat_dau=?";
				PreparedStatement pstmQuery2 = conn.prepareStatement(query2);
				pstmQuery2.setString(1, gioDat);
				ResultSet rs2 = pstmQuery2.executeQuery();
				if(rs2.next()) {
					idKhungGio = rs2.getString("khung_gio_id");
				}
				String updateCLV = "UPDATE ca_lam_viec"
						+ " SET trang_thai = '0'"
						+ " WHERE nhan_vien_id = ?"
						+ " and khung_gio_id = ?"
						+ " and ngay_lam_viec = ?";
				PreparedStatement pstmUpdate = conn.prepareStatement(updateCLV);
				pstmUpdate.setString(1, idNhanVien);
				pstmUpdate.setString(2, idKhungGio);
				pstmUpdate.setString(3, ngayDat);
				pstmUpdate.executeUpdate();
			}
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
	}
	// Chi dung voi HH chua hoan thanh
	public static void DeleteHoaDon(String idHoaDon) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			UpdateCaLamViec(idHoaDon);
			String deleteCTHH = "delete from chi_tiet_hoa_don"
					+ " where hoa_don_id = ?";
			PreparedStatement pstmDelete1 = conn.prepareStatement(deleteCTHH);
			pstmDelete1.setString(1, idHoaDon);
			pstmDelete1.executeUpdate();
            
			String deleteHH = "DELETE FROM hoa_don WHERE hoa_don_id=?";
			PreparedStatement pstmDelete2 = conn.prepareStatement(deleteHH);
			pstmDelete2.setString(1, idHoaDon);
			pstmDelete2.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
	}
	public static void ChangeLich(String idhh, String ngayDat) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			UpdateCaLamViec(idhh);
			String updateHH = "UPDATE hoa_don"
					+ " SET ngay_thuc_hien = ? "
					+ "WHERE hoa_don_id = ?";
			PreparedStatement pstm = conn.prepareStatement(updateHH);
            pstm.setString(1, ngayDat);
            pstm.setString(2, idhh);

            pstm.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySQLConnUtils.rollbackQuietly(conn);
		} finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		
	}
	public static KhachHang InsertKhachHang(KhachHang kh) {
		Connection conn = null;
		KhachHang newKH = null ;
		String newID = "";
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from khach_hang where dien_thoai=?");
            pstm.setString(1,kh.getDienThoai());
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
            	return null;
            }
            else {
            	try {
        			String sql = "insert into khach_hang "
        					+ " (ho_ten, dien_thoai, mat_khau)"
        					+ " values (?,?,?)" ;
        			
        			PreparedStatement pstm1 = conn.prepareStatement(sql);
        			pstm1.setString(1, kh.getTen());
        			pstm1.setString(2, kh.getDienThoai());
        			pstm1.setString(3, kh.getMatKhau());
        			pstm1.executeUpdate();
        			
        			String newIdQuery = "select khach_hang_id from khach_hang where dien_thoai=?";
        			PreparedStatement pstm2 = conn.prepareStatement(newIdQuery);
        			pstm2.setString(1, kh.getDienThoai());
        			ResultSet rs2 = pstm2.executeQuery();
        			if(rs2.next()) {
        				newID = rs2.getString("khach_hang_id");
        			}
        			newKH = new KhachHang(newID,kh.getTen(),kh.getDienThoai(),kh.getMatKhau());
        		}
        		catch(SQLException e) {
        			MySQLConnUtils.rollbackQuietly(conn); 
        			e.printStackTrace();
        		}
            }
		} catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        	MySQLConnUtils.rollbackQuietly(conn);
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return newKH;
	}
	public static Map<String,NhanVien> QueryNhanVien(){
		Connection conn = null;
		Map <String,NhanVien> map = new HashMap<String,NhanVien>();
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from nhan_vien");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
            	String idNhanVien = rs.getString("nhan_vien_id");
            	String hoTen = rs.getString("ho_ten");
            	String dienThoai = rs.getString("dien_thoai");
            	String cmnd = rs.getString("CMND");
            	String trangThai = rs.getString("trang_thai");
            	String idTiemHang = rs.getString("tiem_id");
            	String idTruongCa = rs.getString("truong_ca_id");
            	
            	NhanVien caLamViec = new NhanVien(idNhanVien, hoTen, dienThoai,
            			cmnd, trangThai, idTiemHang, idTruongCa);
            	map.put(idNhanVien, caLamViec);
            	
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return map;
	}
}
