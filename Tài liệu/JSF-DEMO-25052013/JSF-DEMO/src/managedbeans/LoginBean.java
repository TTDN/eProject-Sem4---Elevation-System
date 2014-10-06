package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String username;
	private String password;
	
	private boolean authenticatedSuccess;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public boolean isAuthenticatedSuccess() {
		return authenticatedSuccess;
	}
	public void setAuthenticatedSuccess(boolean authenticatedSuccess) {
		this.authenticatedSuccess = authenticatedSuccess;
	}
	
	@ManagedProperty(value="#{b}")
	private B b;
	
	
	
	public B getB() {
		return b;
	}
	public void setB(B b) {
		this.b = b;
	}
	public String login() {
		if ("admin".equals(username) && "admin".equals(password)) {
			authenticatedSuccess = true;
			b.setOnlineCount(b.getOnlineCount()+1);
			return "using-data-table-3";
		} else {
			return null;
		}
	}

}
