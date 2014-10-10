package managerbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ContactUsDAO;

import dto.ContactUsDTO;


public class ContactUsBean {
	public static final long serialVersionUID = 1L;
	private ContactUsDTO ctu= new ContactUsDTO();
	private List<ContactUsDTO> listctu;
	public ContactUsDTO getCtu() {
		return ctu;
	}
	public void setCtu(ContactUsDTO ctu) {
		this.ctu = ctu;
	}
	public List<ContactUsDTO> getListctu() {
		return listctu;
	}
	public void setListctu(List<ContactUsDTO> listctu) {
		this.listctu = listctu;
		
	}
	public ContactUsBean() {
		
	}
	public String sendmessage() throws ClassNotFoundException, SQLException {
		ContactUsDAO.InsertContactUs(ctu);

		return "register-success?faces-redirect=true";
	}
	
	
	
}
