package bo;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import dao.danhmucDAO;
import dto.danhmuc;

public class danhmucBO extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private danhmuc dm;

	public danhmuc getDm() {
		return dm;
	}

	public void setDm(danhmuc dm) {
		this.dm = dm;
	}

	public String insertDM() throws Exception {
		danhmucDAO dmdao = new danhmucDAO();
		if (dmdao.insertdanhmuc(dm) == true) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String updateDM() {
		danhmucDAO dmdao = new danhmucDAO();
		if (dmdao.updatedanhmuc(dm) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
