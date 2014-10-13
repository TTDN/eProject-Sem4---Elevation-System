package managerbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dto.UserDTO;
import dao.UserDAO;

@ManagedBean(name ="UserBean")

public class UserBean {
	
	public static final long serialVersionUID = 1L;
	private UserDTO us= new UserDTO();
	private List<UserDTO> listUser;
	
	public UserDTO getUs() {
		return us;
	}
	public void setUs(UserDTO us) {
		this.us = us;
	}
	public List<UserDTO> getListUser() {
		return listUser;
	}
	public void setListUser(List<UserDTO> listUser) {
		this.listUser = listUser;
	}
	public UserBean() {
		UserDAO user= new UserDAO();
		listUser = user.FindAllUserDTO();
		// TODO Auto-generated constructor stub
	}
	
	
	public String register() throws ClassNotFoundException, SQLException {
		UserDAO.InsertUser(us);

		return "register-success?faces-redirect=true";
	}
	
	
	public String Login(){
		
		Boolean u = UserDAO.FindByUsername("user", "hihi123");
		/*for (UserDTO u : listuser) {
			if(us.getUserName().equals(u.getUserName()) && us.getPassWord().equals(u.getPassWord())){
				System.out.println("Login th�nh c�ng.");
			}else{
				System.out.println("Fail.");
			}
		}*/
		if(u == true){
			System.out.println("C� user n�y.");
		}else{
			System.out.println("Kh�ng c� user n�y.");
		}
		return null;
	}
}