package BarberStore.beans;

public class ChiTietHoaDon {
	private String id;
	private String idDichVu;
	private String danhGia;
	private int gia;
	
	public ChiTietHoaDon(String id, String idDichVu, 
			String danhGia, int gia) {
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

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}
}
