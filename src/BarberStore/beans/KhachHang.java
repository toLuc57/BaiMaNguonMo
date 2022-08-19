package BarberStore.beans;

public class KhachHang {
	private String id;
	private String ten;
	private String dienThoai;
	private String matKhau;
	
	public KhachHang(String id, String ten, String dienThoai, String matKhau) {
		this.id = id;
		this.ten = ten;
		this.dienThoai = dienThoai;
		this.matKhau = matKhau;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	};
}
