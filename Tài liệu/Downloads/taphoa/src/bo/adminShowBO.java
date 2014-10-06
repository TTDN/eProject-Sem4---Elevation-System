package bo;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.admimDAO;
import dto.admin;

public class adminShowBO extends ActionSupport {

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

	private int idAD;

	public int getIdAD() {
		return idAD;
	}

	public void setIdAD(int idAD) {
		this.idAD = idAD;
	}

	private admin ad;

	public admin getAd() {
		return ad;
	}

	public void setAd(admin ad) {
		this.ad = ad;
	}

	private ArrayList<admin> listad = new ArrayList<admin>();

	public ArrayList<admin> getListad() {
		return listad;
	}

	public void setListad(ArrayList<admin> listad) {
		this.listad = listad;
	}

	public String listadmin() throws Exception {
		admimDAO adao = new admimDAO();
		listad = adao.findalladmin();
		return SUCCESS;
	}

	public String getadmin() throws Exception {
		admimDAO adao = new admimDAO();
		ad = adao.findidadmin(id);
		session = ActionContext.getContext().getSession();
		session.put("add", ad);
		return SUCCESS;
	}

	public String deleteuserAD() throws Exception {
		admimDAO adao = new admimDAO();
		if (adao.deleteadmin(idAD) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
