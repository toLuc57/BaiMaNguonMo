package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BarberStore.beans.ChiTietHoaDon;
import BarberStore.beans.HoaDon;
import BarberStore.beans.KhachHang;
import BarberStore.jdbc.MySQLConnUtils;

public class UserUtils {
	
	public static KhachHang QueryKhachHang(String dienThoai, String matKhau) {
		Connection conn = null;
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
            	if(matKhau == null)	{
            		// default value
            		matKhau = "123456";
            	}
            	try {
        			String sql = "insert into khach_hang "
        					+ " (ho_ten, dien_thoai, mat_khau)"
        					+ " values (?,?,?)" ;
        			
        			PreparedStatement pstm1 = conn.prepareStatement(sql);
        			pstm1.setString(1, tenMacDinh);
        			pstm1.setString(2, dienThoai);
        			pstm1.setString(3, matKhau);
        			pstm1.executeUpdate();
        		}
        		catch(SQLException e) {
        			MySQLConnUtils.rollbackQuietly(conn); 
        			e.printStackTrace();
        		}
            	return new KhachHang("",tenMacDinh,dienThoai, matKhau);
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
            if(rs.next()) {
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
            if(rs.next()) {
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
            if(rs.next()) {
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
}
