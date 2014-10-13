package managerbean;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import dao.AdminDAO;
import dto.AdminDTO;

@ManagedBean(name ="registeradmin")
public class AdminBean {
	public static final long serialVersionUID = 1L;
	private AdminDTO ad= new AdminDTO();
	private List<AdminDTO> listAdmin;
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
	public String register() throws ClassNotFoundException, SQLException {
	AdminDAO.InsertAdmin(ad);

		return "register-success?faces-redirect=true";
	}

}
