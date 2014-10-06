package bo;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.cthoadonDAO;
import dto.cthoadon;

public class cthoadonshow extends ActionSupport {

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

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int idCTHD;

	public int getIdCTHD() {
		return idCTHD;
	}

	public void setIdCTHD(int idCTHD) {
		this.idCTHD = idCTHD;
	}

	private cthoadon cthd;

	public cthoadon getCthd() {
		return cthd;
	}

	public void setCthd(cthoadon cthd) {
		this.cthd = cthd;
	}

	private ArrayList<cthoadon> listcthd = new ArrayList<cthoadon>();

	public ArrayList<cthoadon> getListcthd() {
		return listcthd;
	}

	public void setListcthd(ArrayList<cthoadon> listcthd) {
		this.listcthd = listcthd;
	}

	public String selectCTHD() {
		cthoadonDAO cthdao = new cthoadonDAO();
		listcthd = cthdao.findallcthoadon();
		return SUCCESS;
	}

	public String getCTHD() {
		cthoadonDAO cthdao = new cthoadonDAO();
		cthd = cthdao.findidcthoadon(id);
		session = ActionContext.getContext().getSession();
		session.put("cthoadon", cthd);
		return SUCCESS;
	}
}
