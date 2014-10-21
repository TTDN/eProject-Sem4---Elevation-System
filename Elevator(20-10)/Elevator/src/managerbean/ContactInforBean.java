package managerbean;


import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ContactInforDAO;
import dao.FeedbackDAO;
import dto.ContactInforDTO;
import dto.FeedbackDTO;


@ManagedBean(name ="ContactInforBean")
@SessionScoped
public class ContactInforBean {
	private ContactInforDTO ct= new ContactInforDTO();
	
public ContactInforDTO getCt() {
		return ct;
	}
	public void setCt(ContactInforDTO ct) {
		this.ct = ct;
	}
//public List<ContactInforDTO> getListContactInfor() {
//		List<ContactInforDTO> ls = new ContactInforDAO().findallContactInfor();
//		
//		
//		return ls ;
//	}
	public ContactInforBean() {
		super();
	
		ct=new ContactInforDAO().findallContact();
		// TODO Auto-generated constructor stub
	}
	public String updateCTIF() throws ClassNotFoundException, SQLException {
		
//		ct=new ContactInforDAO().findallContactInfor();
		ContactInforDTO contact=new ContactInforDTO();
		contact.setAddress(ct.getAddress());
		contact.setTelePhone(ct.getTelePhone());
		contact.setMobilePhone(ct.getMobilePhone());
		contact.setEmail(ct.getEmail());
		contact.setFAX(ct.getFAX());
		contact.setSkype(ct.getSkype());
		contact.setYahoo(ct.getYahoo());
		contact=ct;
		
		ContactInforDAO.updateContactInfor(contact);
			return "register-success?faces-redirect=true";
		}
}
