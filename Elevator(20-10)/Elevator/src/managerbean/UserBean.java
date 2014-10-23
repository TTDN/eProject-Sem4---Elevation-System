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
	public UserBean() {
		UserDAO user= new UserDAO();
		listUser = user.FindAllUserDTO();
		// TODO Auto-generated constructor stub
	}
	public String getSession(){
		//System.out.println(HttpUtil.getFromSession("username"));
		return String.valueOf(HttpUtil.getFromSession("username"));
	}
	public static String getSessionId(){
		//System.out.println(HttpUtil.getFromSession("id"));
		return String.valueOf(HttpUtil.getFromSession("id"));
	}
	public String DestroySession(){
		HttpUtil.putToSession("username", null);
		HttpUtil.putToSession("id", null);
		return "Index";
	}
	
	public String register() throws ClassNotFoundException, SQLException {
		UserDAO.InsertUser(us);

		return "Login?faces-redirect=true";
	}
	
	
public String Login(){
		
		Boolean u = UserDAO.FindByUsername(us.getUserName(), us.getPassWord());

		//System.out.println(us.getUserName() + us.getPassWord());
		if(u == true){
			//System.out.println("Co");
			HttpUtil.putToSession("username", us.getUserName());
			UserDTO user=new UserDTO();
			
			user=UserDAO.findUser(us.getUserName());
			
			HttpUtil.putToSession("id", user.getID_User());
			return "Index?faces-redirect=true";
		}else{
			//System.out.println("Ko");
			HttpUtil.putToSession("username", us.getUserName());
		}
		return null;
	}

}