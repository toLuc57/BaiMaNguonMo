package BarberStore.beans;

public class NhanVien {
	private String id;
	private String hoTen;
	private String dienThoai;
	private String cmnd;
	private String trangThai;
	private String idTiem;
	private String idTruongCa;
	
	public NhanVien(String id, String hoTen, String dienThoai,
			String cmnd, String trangThai, String idTiem, String idTruongCa) {
		this.id = id;
		this.hoTen = hoTen;
		this.dienThoai = dienThoai;
		this.cmnd = cmnd;
		this.trangThai = trangThai;
		this.idTiem = idTiem;
		this.idTruongCa = idTruongCa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getIdTiem() {
		return idTiem;
	}

	public void setIdTiem(String idTiem) {
		this.idTiem = idTiem;
	}

	public String getIdTruongCa() {
		return idTruongCa;
	}

	public void setIdTruongCa(String idTruongCa) {
		this.idTruongCa = idTruongCa;
	}
}
