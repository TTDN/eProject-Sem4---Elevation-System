package bo;

import com.opensymphony.xwork2.ActionSupport;

import dao.hoadonDAO;
import dto.hoadon;

public class hoadonBO extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private hoadon hd;

	public hoadon getHd() {
		return hd;
	}

	public void setHd(hoadon hd) {
		this.hd = hd;
	}

	public String insertHD() throws Exception {
		hoadonDAO hddao = new hoadonDAO();
		if (hddao.inserthoadon(hd) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
