package DTO;

public class sinhvienDTO {
	private int MSSV;
	private String HoVaTen;
	private String Lop;
	private String GioiTinh;
	private String DiaChi;
	private int CMND;
	private int SDT;
	public sinhvienDTO( int mssv, String hovaten, String lop,
			String gioitinh, String diachi, int cmnd, int sdt) {
		super();
		
		MSSV = mssv;
		HoVaTen = hovaten;
		Lop = lop;
		GioiTinh = gioitinh;
		DiaChi = diachi;
		CMND = cmnd;
		SDT = sdt;
	}
	public sinhvienDTO()
	{
		super();
	}
	public int getMSSV() {
		return MSSV;
	}
	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}
	public String getHoVaTen() {
		return HoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		HoVaTen = hoVaTen;
	}
	public String getLop() {
		return Lop;
	}
	public void setLop(String lop) {
		Lop = lop;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public int getCMND() {
		return CMND;
	}
	public void setCMND(int cMND) {
		CMND = cMND;
	}
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
}
