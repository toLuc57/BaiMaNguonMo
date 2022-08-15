package BarberStore.beans;

public class DichVu {
	private String id;
	private String ten;
	private int gia;
	private String ghiChu;
	
	public DichVu(String id, String ten, int gia, String ghiChu) {
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.ghiChu = ghiChu;
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
	
	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
}
