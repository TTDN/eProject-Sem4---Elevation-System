package dto;

public class cthoadon {
	int idct;
	int idsp;
	int soluong;
	int thanhtien;
	int gia;

	public cthoadon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public cthoadon(int idct, int idsp, int soluong, int thanhtien, int gia) {
		super();
		this.idct = idct;
		this.idsp = idsp;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
		this.gia = gia;
	}

	public int getIdct() {
		return idct;
	}

	public void setIdct(int idct) {
		this.idct = idct;
	}

	public int getIdsp() {
		return idsp;
	}

	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

}
