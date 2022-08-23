package BarberStore.beans;

public class HoaDon {
	private String id;
	private String idKhachHang;
	private String trangThai;
	private String ngayDat;
	private String ngayThucHien;
	private String idNhanVien;
	
	public HoaDon(String id, String idKhachHang, String trangThai,
			String ngayDat, String ngayThucHien, String idNhanVien) {
		this.setId(id);
		this.setIdKhachHang(idKhachHang);
		this.setTrangThai(trangThai);
		this.setNgayDat(ngayDat);
		this.setNgayThucHien(ngayThucHien);
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

	public String getNgayThucHien() {
		return ngayThucHien;
	}

	public void setNgayThucHien(String ngayThucHien) {
		this.ngayThucHien = ngayThucHien;
	}
	public String getChiHienThiNgay() {
		String[] date = ngayThucHien.split(" ");
		return date[0];
	}
}
