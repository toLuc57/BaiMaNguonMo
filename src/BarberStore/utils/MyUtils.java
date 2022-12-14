package BarberStore.utils;

import javax.servlet.http.HttpSession;

import BarberStore.beans.KhachHang;

public class MyUtils {	
	public static void storeLoginedUser(HttpSession session, KhachHang customer) {
		session.setAttribute("loginedUser", customer);
	}
	public static KhachHang getLoginedUser(HttpSession session) {
		return (KhachHang) session.getAttribute("loginedUser");
	}
	public static void deleteLoginedUser(HttpSession session) {
		session.setAttribute("loginedUser", null);
	}
}
