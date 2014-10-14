package managerbean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ContactInforDAO;
import dto.ContactInforDTO;


@ManagedBean(name ="ContactInforBean")
@SessionScoped
public class ContactInforBean {
	
public List<ContactInforDTO> getListContactInfor() {
		List<ContactInforDTO> ls = new ContactInforDAO().findallContactInfor();
		return ls ;
	}
	public ContactInforBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
