package managedbeans;

import javax.faces.bean.ManagedBean;

import dto.User;

@ManagedBean(name="registerBean")
public class RegisterBean {

	private User user;
	
	public RegisterBean() {
		user = new User();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String register() {		
		System.out.println(user.toString());
		
		// call BO to save to database;
		
		return "register-success";   // add ?faces-redirect=true to redirect instead of fowarding
	}
	
}
