package bean;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;

import DAO.sinhvienDAO;
import DTO.sinhvienDTO;

@ManagedBean(name = "registerBean")
public class sinhvienBean {
	public static final long serialVersionUID = 1L;
	private sinhvienDTO sv;

	public sinhvienBean() {
		sv = new sinhvienDTO();
	}

	public sinhvienDTO getSv() {
		return sv;
	}

	public void setSv(sinhvienDTO sv) {
		this.sv = sv;
	}

	// public sinhvienDTO getSv() {
	// return sv;
	// }
	//
	// public void setSv(sinhvienDTO sv) {
	// this.sv = sv;
	// }
	//
	public String register() throws ClassNotFoundException, SQLException {
		sinhvienDAO.add(sv);

		return "register-success?faces-redirect=true";
	}

}
