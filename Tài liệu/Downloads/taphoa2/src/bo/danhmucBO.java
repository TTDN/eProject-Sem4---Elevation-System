package bo;

import javax.faces.bean.ManagedBean;

import dao.danhmucDAO;
import dto.danhmuc;

@ManagedBean(name = "danhmuc")
public class danhmucBO {
	private danhmuc dm = new danhmuc();

	public danhmuc getDm() {
		return dm;
	}

	public void setDm(danhmuc dm) {
		this.dm = dm;
	}

	public String insertSP() {
		danhmucDAO dmdao = new danhmucDAO();
		dmdao.insertdanhmuc(dm);
		return "thanhcong";
	}
}
