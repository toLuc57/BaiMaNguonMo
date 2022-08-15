package BarberStore.beans;

public class ChiTietHoaDon {
	private String id;
	private String idDichVu;
	private String danhGia;
	private double gia;
	
	public ChiTietHoaDon(String id, String idDichVu, 
			String danhGia, double gia) {
		this.setId(id);
		this.setIdDichVu(idDichVu);
		this.setDanhGia(danhGia);
		this.setGia(gia);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdDichVu() {
		return idDichVu;
	}

	public void setIdDichVu(String idDichVu) {
		this.idDichVu = idDichVu;
	}

	public String getDanhGia() {
		return danhGia;
	}

	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
}
