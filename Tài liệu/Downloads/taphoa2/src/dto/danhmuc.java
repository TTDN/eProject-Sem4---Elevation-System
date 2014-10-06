package dto;

public class danhmuc {
	int iddm;
	String tendm;
	public danhmuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public danhmuc(int iddm, String tendm) {
		super();
		this.iddm = iddm;
		this.tendm = tendm;
	}
	public int getIddm() {
		return iddm;
	}
	public void setIddm(int iddm) {
		this.iddm = iddm;
	}
	public String getTendm() {
		return tendm;
	}
	public void setTendm(String tendm) {
		this.tendm = tendm;
	}
	
}
