package dto;

public class ContactInforDTO {
	private int ID_ContactInfo;
	private String MobilePhone;
	private String TelePhone;
	private String FAX;
	private String Email;
	private String Skype;
	private String Yahoo;
	private String Address;
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getID_ContactInfo() {
		return ID_ContactInfo;
	}
	public void setID_ContactInfo(int iD_ContactInfo) {
		ID_ContactInfo = iD_ContactInfo;
	}
	public String getMobilePhone() {
		return MobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		MobilePhone = mobilePhone;
	}
	public String getTelePhone() {
		return TelePhone;
	}
	public void setTelePhone(String telePhone) {
		TelePhone = telePhone;
	}
	public String getFAX() {
		return FAX;
	}
	public void setFAX(String fAX) {
		FAX = fAX;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSkype() {
		return Skype;
	}
	public void setSkype(String skype) {
		Skype = skype;
	}
	public String getYahoo() {
		return Yahoo;
	}
	public void setYahoo(String yahoo) {
		Yahoo = yahoo;
	}
	
	public ContactInforDTO(int iD_ContactInfo, String mobilePhone,
			String telePhone, String fAX, String email, String skype,
			String yahoo, String address) {
		super();
		ID_ContactInfo = iD_ContactInfo;
		MobilePhone = mobilePhone;
		TelePhone = telePhone;
		FAX = fAX;
		Email = email;
		Skype = skype;
		Yahoo = yahoo;
		Address = address;
	}
	public ContactInforDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}