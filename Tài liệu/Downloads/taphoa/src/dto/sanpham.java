package dto;

public class sanpham {
	int idsp;
	String tensp;
	String hinhanh;
	int gia;
	int soluong;
	int iddm;
	public sanpham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public sanpham(int idsp, String tensp, String hinhanh, int gia,
			int soluong, int iddm) {
		super();
		this.idsp = idsp;
		this.tensp = tensp;
		this.hinhanh = hinhanh;
		this.gia = gia;
		this.soluong = soluong;
		this.iddm = iddm;
	}
	public int getIdsp() {
		return idsp;
	}
	public void setIdsp(int idsp) {
		this.idsp = idsp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getIddm() {
		return iddm;
	}
	public void setIddm(int iddm) {
		this.iddm = iddm;
	}
	
	
}
