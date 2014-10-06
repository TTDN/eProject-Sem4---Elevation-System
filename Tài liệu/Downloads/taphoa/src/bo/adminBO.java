package bo;

import com.opensymphony.xwork2.ActionSupport;

import dao.admimDAO;
import dto.admin;

public class adminBO extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private admin ad;

	public admin getAd() {
		return ad;
	}

	public void setAd(admin ad) {
		this.ad = ad;
	}

	public String insertMB() throws Exception {
		admimDAO adao = new admimDAO();
		if (adao.insertadmin(ad) == true) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String updateadmin() throws Exception {
		admimDAO adao = new admimDAO();
		if (adao.updateadmin(ad) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
