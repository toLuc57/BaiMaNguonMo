package BarberStore.beans;

public class Tiem {
	private String id;
	private String ten;
	private String dienThoai;
	private String diaChi;
	
	public Tiem(String ten, String dienThoai, String diaChi) {
		this.ten = ten;
		this.dienThoai = dienThoai;
		this.diaChi = diaChi;
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

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
}
