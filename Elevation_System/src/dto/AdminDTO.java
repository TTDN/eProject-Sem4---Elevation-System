package dto;

public class AdminDTO {
	private int ID_Admin;
	private String UserName;
	private String PassWord;
	private String Phone;
	private String Address;
	private String Email;
	private String Fullname;
	
	
	public AdminDTO(int iD_Admin, String userName, String passWord,
			String phone, String address, String email, String fullname) {
		super();
		ID_Admin = iD_Admin;
		UserName = userName;
		PassWord = passWord;
		Phone = phone;
		Address = address;
		Email = email;
		Fullname = fullname;
	}
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public int getID_Admin() {
		return ID_Admin;
		
	}
	public void setID_Admin(int iD_Admin) {
		ID_Admin = iD_Admin;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
