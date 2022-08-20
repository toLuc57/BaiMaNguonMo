package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return null;
	}
}
