package BarberStore.beans;

public class Tiem {
	private String id;
	private String ten;
	private String dienThoai;
	private String tenDuong;
	private String phuong;
	private String quan;
	
	public Tiem(String id, String ten, String dienThoai, String tenDuong, 
			String phuong, String quan) {
		this.id = id;
		this.ten = ten;
		this.dienThoai = dienThoai;
		this.tenDuong = tenDuong;
		this.phuong = phuong;
		this.quan = quan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getTenDuong() {
		return tenDuong;
	}

	public void setTenDuong(String tenDuong) {
		this.tenDuong = tenDuong;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}
}
