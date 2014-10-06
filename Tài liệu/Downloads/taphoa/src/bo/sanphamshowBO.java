package bo;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.sanphamDao;
import dto.sanpham;

public class sanphamshowBO extends ActionSupport {

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

	private int idSP;

	public int getIdSP() {
		return idSP;
	}

	public void setIdSP(int idSP) {
		this.idSP = idSP;
	}

	private sanpham sp;

	public sanpham getSp() {
		return sp;
	}

	public void setSp(sanpham sp) {
		this.sp = sp;
	}

	private ArrayList<sanpham> listsp = new ArrayList<sanpham>();

	public ArrayList<sanpham> getListsp() {
		return listsp;
	}

	public void setListsp(ArrayList<sanpham> listsp) {
		this.listsp = listsp;
	}

	public String insertSP() throws Exception {
		sanphamDao spdao = new sanphamDao();
		listsp = spdao.findallsanpham();
		return SUCCESS;
	}

	public String deleteSP() throws Exception {
		sanphamDao spdao = new sanphamDao();
		if (spdao.deletesanpham(idSP) == true) {
			return SUCCESS;
		}
		return ERROR;
	}

	public String getSP() {
		sanphamDao spdao = new sanphamDao();
		sp = spdao.findidsanpham(id);
		session = ActionContext.getContext().getSession();
		session.put("sanpham", sp);
		return SUCCESS;
	}
}
