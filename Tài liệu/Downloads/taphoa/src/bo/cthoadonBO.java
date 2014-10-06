package bo;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.cthoadonDAO;
import dto.cthoadon;

public class cthoadonBO extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private cthoadon cthd;

	public cthoadon getCthd() {
		return cthd;
	}

	public void setCthd(cthoadon cthd) {
		this.cthd = cthd;
	}

	public String insertCTHD() throws Exception {
		cthoadonDAO cthdao = new cthoadonDAO();
		if (cthdao.insertcthoadon(cthd) == true) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String upCTHD() {
		cthoadonDAO cthdao = new cthoadonDAO();
		Map<String, Object> session = ActionContext.getContext().getSession();
		cthd = (cthoadon) session.get("cthoadon");
		cthdao.updatecthoadon(cthd);
		return SUCCESS;
	}
}
