package dto;

public class ContactUsDTO {
	private int ID_ContactUs;
	private String Name;
	private String Telephone;
	private String CompanyName;
	private String Contents;
	public int getID_ContactUs() {
		return ID_ContactUs;
	}
	public void setID_ContactUs(int iD_ContactUs) {
		ID_ContactUs = iD_ContactUs;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
	public ContactUsDTO(int iD_ContactUs, String name, String telephone,
			String companyName, String contents) {
		super();
		ID_ContactUs = iD_ContactUs;
		Name = name;
		Telephone = telephone;
		CompanyName = companyName;
		Contents = contents;
	}
	public ContactUsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
