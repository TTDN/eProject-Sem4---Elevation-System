package dto;

public class ComplaintDTO {
	private int ID_Complaint;
	private int ID_User;
	private int ID_Order;
	private String Contents;
	private String Fullname;
	private String Email;
	
	public String getFullname() {
		return Fullname;
	}
	public void setFullname(String fullname) {
		Fullname = fullname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getID_Complaint() {
		return ID_Complaint;
	}
	public void setID_Complaint(int iD_Complaint) {
		ID_Complaint = iD_Complaint;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
	}
	public int getID_Order() {
		return ID_Order;
	}
	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	
	public ComplaintDTO(int iD_Complaint, int iD_User, int iD_Order,
			String contents, String fullname, String email) {
		super();
		ID_Complaint = iD_Complaint;
		ID_User = iD_User;
		ID_Order = iD_Order;
		Contents = contents;
		Fullname = fullname;
		Email = email;
	}
	public ComplaintDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
