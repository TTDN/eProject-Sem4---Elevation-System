package managerbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import util.HttpUtil;
import dao.AdminDAO;
import dto.AdminDTO;

@ManagedBean(name = "AdminBean")
public class AdminBean {
	public static final long serialVersionUID = 1L;
	private AdminDTO ad = new AdminDTO();
	private List<AdminDTO> listAdmin;
	public String PP;
	public String NP;
	public String RP;

	public String getPP() {
		return PP;
	}

	public void setPP(String pP) {
		PP = pP;
	}

	public String getNP() {
		return NP;
	}

	public void setNP(String nP) {
		NP = nP;
	}

	public String getRP() {
		return RP;
	}

	public void setRP(String rP) {
		RP = rP;
	}

	public AdminDTO getAd() {
		return ad;
	}

	public void setAd(AdminDTO ad) {
		this.ad = ad;
	}

	public List<AdminDTO> getListAdmin() {
		return listAdmin;
	}

	public void setListAdmin(List<AdminDTO> listAdmin) {
		this.listAdmin = listAdmin;
	}

	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Copy từ đây trở xuống.
	public String getSessionAdminLoginNotification() {
		return String
				.valueOf(HttpUtil.getFromSession("AdminLoginNotification"));
	}

	public String getSessionUsername(){
		return String.valueOf(HttpUtil.getFromSession("AdminUsername"));
	}
	
	public String getSessionID_Admin() {
		return String.valueOf(HttpUtil.getFromSession("IDAdmin"));
	}
	
	public String LogOut_DestroySessionAdmin(){
		HttpUtil.putToSession("AdminUsername", null);
		HttpUtil.putToSession("IDAdmin", null);
		return "AdminLogin";
	}

	public String Login() {
		Boolean b = AdminDAO.Login(ad.getUserName(), ad.getPassWord());
		if (b == true) {
			HttpUtil.putToSession("AdminUsername", ad.getUserName());
			AdminDTO admin = new AdminDTO();
			admin = AdminDAO.findUser(ad.getUserName());
			HttpUtil.putToSession("AdminID", admin.getID_Admin());
			return "AdminManage";
		} else {
			HttpUtil.putToSession("AdminLoginNotification",
					"Username or password incorrect, please check and try again.");
		}
		return null;
	}

	public String AddAdmin() {

		Boolean b = AdminDAO.InsertAdmin(ad);

		if (b) {
			HttpUtil.putToSession("AdminAddAdminNotification", "Success!");
		} else {
			HttpUtil.putToSession("AdminAddAdminNotification",
					"Error, please check and try again.");
		}
		return "AdminManage";
	}

	public String ChangeProfile() {

		Boolean b = AdminDAO.ChangeProfile(ad.getFullname(), ad.getPhone(),
				ad.getEmail(), ad.getAddress(), ad.getID_Admin());

		if (b) {
			HttpUtil.putToSession("AdminChangeProfileNotification", "Success!");
		} else {
			HttpUtil.putToSession("AdminChangeProfileNotification",
					"Error, please check and try again.");
		}
		return null;
	}

	public String ChangePassword() {

		if (NP.equals(RP)) {
			if (AdminDAO.ChangePassword(NP,
					Integer.parseInt(getSessionID_Admin()))) {
				// success
			} else {
				// fail
			}
		} else {
			HttpUtil.putToSession("AdminChangePasswordNotification",
					"Error, please check and try again.");
		}
		return null;
	}
}