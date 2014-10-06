package dto;

import java.sql.Date;

public class hoadon {
	int idhd;
	int idct;
	Date ngay;
	int tongtien;

	public hoadon() {
		super();

	}

	public hoadon(int idhd, int idct, Date ngay, int tongtien) {
		super();
		this.idhd = idhd;
		this.idct = idct;
		this.ngay = ngay;
		this.tongtien = tongtien;
	}

	public int getIdhd() {
		return idhd;
	}

	public void setIdhd(int idhd) {
		this.idhd = idhd;
	}

	public int getIdct() {
		return idct;
	}

	public void setIdct(int idct) {
		this.idct = idct;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

}