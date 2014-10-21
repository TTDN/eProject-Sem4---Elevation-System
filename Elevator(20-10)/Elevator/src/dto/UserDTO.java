package dto;

public class UserDTO {
	
private  int ID_User;
private String UserName;
private String PassWord;
private String FullName;
private String Email;
private String Address;
private String Company;
public int getID_User() {
	return ID_User;
}
public void setID_User(int iD_User) {
	ID_User = iD_User;
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
public String getFullName() {
	return FullName;
}
public void setFullName(String fullName) {
	FullName = fullName;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getCompany() {
	return Company;
}
public void setCompany(String company) {
	Company = company;
}
public UserDTO(int iD_User, String userName, String passWord, String fullName,
		String email, String address, String company) {
	super();
	ID_User = iD_User;
	UserName = userName;
	PassWord = passWord;
	FullName = fullName;
	Email = email;
	Address = address;
	Company = company;
}
public UserDTO() {
	super();
	// TODO Auto-generated constructor stub
}

	

}
