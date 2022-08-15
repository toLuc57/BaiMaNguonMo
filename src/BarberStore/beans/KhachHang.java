package BarberStore.beans;

public class KhachHang {
	private String id;
	private String ten;
	private String dienThoai;
	private String matKhau;
	
	public KhachHang(String ten, String dienThoai, String matKhau) {
		this.setTen(ten);
		this.setDienThoai(dienThoai);
		this.setMatKhau(matKhau);
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
