package bo;

import com.opensymphony.xwork2.ActionSupport;

import dao.sanphamDao;

import dto.sanpham;

public class sanphamBO extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private sanpham sp;

	public sanpham getSp() {
		return sp;
	}

	public void setSp(sanpham sp) {
		this.sp = sp;
	}

	public String insertSP() throws Exception {
		sanphamDao spdao = new sanphamDao();
		spdao.insertsanpham(sp);
		return SUCCESS;
	}

	public String updateSP() {
		sanphamDao spdao = new sanphamDao();
		if (spdao.updatesanpham(sp) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
