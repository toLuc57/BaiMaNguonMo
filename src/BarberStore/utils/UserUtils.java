package BarberStore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import BarberStore.beans.KhachHang;
import BarberStore.jdbc.MySQLConnUtils;

public class UserUtils {
	
	public static boolean QueryKhachHang(String sdt, String matKhau) {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConUtils();
			
            PreparedStatement pstm = conn.prepareStatement("select *from khach_hang where sdt=?");
            ResultSet rs = pstm.executeQuery();
            if(rs.next()) {
            	return true;
            }
            else {
            	if(matKhau == null)
            	try {
        			conn = MySQLConnUtils.getMySQLConUtils();
        			String sql = "insert into " + table 
        					+ " (" + id + ", " + name + ", " 
        					+ theoryLesson + ", " + practiceLesson + ")"
        					+ " values (?,?,?,?)" ;
        			
        			PreparedStatement pstm = conn.prepareStatement(sql);
        			String newID = getNewID();
        			pstm.setString(1,newID);
        			pstm.setString(2, insertRow.getName());
        			pstm.setInt(3, insertRow.getNumberOfTheoryLesson());
        			pstm.setInt(4, insertRow.getNumberOfPracticeLesson());
        			
        			pstm.executeUpdate();
        			listID.add(newID);
        		}
        		catch(ClassNotFoundException | SQLException e) {
        			MySQLConnUtils.closeQuietly(conn); 
        			e.printStackTrace();
        		}
        		finally {
        			MySQLConnUtils.closeQuietly(conn); 
        		}
            }
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
        	e.printStackTrace();
        }
		finally {
			MySQLConnUtils.closeQuietly(conn);
		}
		return false;
	}
}
