package BarberStore.beans;

public class CaLamViec {
	private String idNhanVien;
	private String idKhungGio;
	private String ngayLamViec;
	private int trangThai;
	
	public CaLamViec(String idNhanVien, String idKhungGio, 
			String ngayLamViec, int trangThai) {
		this.idNhanVien = idNhanVien;
		this.idKhungGio = idKhungGio;
		this.ngayLamViec = ngayLamViec;
		this.trangThai = trangThai;
	}
	
	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getIdKhungGio() {
		return idKhungGio;
	}

	public void setIdKhungGio(String idKhungGio) {
		this.idKhungGio = idKhungGio;
	}

	public String getNgayLamViec() {
		return ngayLamViec;
	}

	public void setNgayLamViec(String ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
}
