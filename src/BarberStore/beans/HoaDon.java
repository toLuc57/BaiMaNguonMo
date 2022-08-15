package BarberStore.beans;

public class HoaDon {
	private String id;
	private String idKhachHang;
	private String trangThai;
	private String ngayDat;
	private String idNhanVien;
	
	private HoaDon(String idKhachHang, String trangThai,
			String ngayDat, String idNhanVien) {
		this.setIdKhachHang(idKhachHang);
		this.setTrangThai(trangThai);
		this.setNgayDat(ngayDat);
		this.setIdNhanVien(idNhanVien);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
}
