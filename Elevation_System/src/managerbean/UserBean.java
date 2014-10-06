package managerbean;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dto.UserDTO;
import dao.UserDAO;

@ManagedBean(name ="registeruser")

public class UserBean {
	public static final long serialVersionUID = 1L;
	private UserDTO us= new UserDTO();
	private List<UserDAO> listUser;
	public UserDTO getUs() {
		return us;
	}
	public void setUs(UserDTO us) {
		this.us = us;
	}
	public List<UserDAO> getListUser() {
		return listUser;
	}
	public void setListUser(List<UserDAO> listUser) {
		this.listUser = listUser;
	}
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String register() throws ClassNotFoundException, SQLException {
		UserDAO.InsertUser(us);

		return "register-success?faces-redirect=true";
	}
	
//	public String update() throws ClassNotFoundException, SQLException {
//		UserDAO.update(us);
//
//		return "register-success?faces-redirect=true";
//	}

}
