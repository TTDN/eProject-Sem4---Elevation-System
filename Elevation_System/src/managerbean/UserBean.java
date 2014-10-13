package managerbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;

import util.HttpUtil;
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
	public String getSession(){
		return String.valueOf(HttpUtil.getFromSession("username"));
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
		
		Boolean u = UserDAO.FindByUsername(us.getUserName(), us.getPassWord());
//		for (UserDTO u : listuser) {
//			if(us.getUserName().equals(u.getUserName()) && us.getPassWord().equals(u.getPassWord())){
//				System.out.println("Login thành công.");
//			}else{
//				System.out.println("Fail.");
//			}
//		}
		System.out.println(us.getUserName() + us.getPassWord());
		if(u == true){
			System.out.println("Có user này.");
			HttpUtil.putToSession("username", us.getUserName());
//			return "index?faces-redirect=true";
		}else{
			System.out.println("Không có user này.");
			HttpUtil.putToSession("username", us.getUserName());
		}
		return null;
	}
}