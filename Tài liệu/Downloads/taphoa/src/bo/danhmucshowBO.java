package bo;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.danhmucDAO;
import dto.danhmuc;

public class danhmucshowBO extends ActionSupport {

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

	private int idDM;

	public int getIdDM() {
		return idDM;
	}

	public void setIdDM(int idDM) {
		this.idDM = idDM;
	}

	private danhmuc dm;

	public danhmuc getDm() {
		return dm;
	}

	public void setDm(danhmuc dm) {
		this.dm = dm;
	}

	private ArrayList<danhmuc> listdm = new ArrayList<danhmuc>();

	public ArrayList<danhmuc> getListdm() {
		return listdm;
	}

	public void setListdm(ArrayList<danhmuc> listdm) {
		this.listdm = listdm;
	}

	public String selectDM() throws Exception {
		danhmucDAO dmdao = new danhmucDAO();
		listdm = dmdao.findalldanhmuc();
		return SUCCESS;
	}

	public String getDM() throws Exception {
		danhmucDAO dmdao = new danhmucDAO();
		dm = dmdao.findidanhmuc(id);
		session = ActionContext.getContext().getSession();
		session.put("danhmuc", dm);
		return SUCCESS;
	}

	public String deleteDM() throws Exception {
		danhmucDAO dmdao = new danhmucDAO();
		if (dmdao.deletedanhmuc(idDM) == true) {
			return SUCCESS;
		}
		return ERROR;

	}
}
