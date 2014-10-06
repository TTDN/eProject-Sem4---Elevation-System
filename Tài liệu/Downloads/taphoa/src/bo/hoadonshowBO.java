package bo;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.hoadonDAO;
import dto.hoadon;

public class hoadonshowBO extends ActionSupport implements ParameterAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, String[]> parameters;
	private hoadon hd;

	public hoadon getHd() {
		return hd;
	}

	public void setHd(hoadon hd) {
		this.hd = hd;
	}

	private ArrayList<hoadon> listhd = new ArrayList<hoadon>();

	public ArrayList<hoadon> getListhd() {
		return listhd;
	}

	public void setListhd(ArrayList<hoadon> listhd) {
		this.listhd = listhd;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		// TODO Auto-generated method stub
		this.parameters = arg0;
	}

	public String selectHD() throws Exception {
		hoadonDAO hadao = new hoadonDAO();
		listhd = hadao.findallhoadon();
		return SUCCESS;
	}

	public String deleteHD() throws Exception {
		hoadonDAO hadao = new hoadonDAO();
		if (hadao.deletehoadon(Integer.parseInt(parameters.get("idHD")[0])) == true) {
			return SUCCESS;
		}
		return ERROR;
	}
}
