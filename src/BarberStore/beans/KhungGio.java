package BarberStore.beans;

public class KhungGio {
	private String id;
	private String batDau;
	private String ketThuc;
	
	public KhungGio(String id, String batDau, String ketThuc) {
		this.id = id;
		this.batDau = batDau;
		this.ketThuc = ketThuc;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatDau() {
		return batDau;
	}

	public void setBatDau(String batDau) {
		this.batDau = batDau;
	}

	public String getKetThuc() {
		return ketThuc;
	}

	public void setKetThuc(String ketThuc) {
		this.ketThuc = ketThuc;
	}
}
