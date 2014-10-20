package dto;
import java.util.Date;

public class QuotesDTO {
	private int ID_Order;
	private int ID_Product;
	private String ProductName;
	private String FloorNumber;
	private String Speed;
	private String HoleSize;
	private String FullName;
	private String Address;
	private String Email;
	private String Telephone;
	private Date DateOrder;
	private Boolean Status;
	private Integer Cost;
	private String Payment;
	private String Weight;
	

	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public int getID_Product() {
		return ID_Product;
	}
	public void setID_Product(int iD_Product) {
		ID_Product = iD_Product;
	}

	public int getID_Order() {
		return ID_Order;
	}
	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getFloorNumber() {
		return FloorNumber;
	}
	public void setFloorNumber(String floorNumber) {
		FloorNumber = floorNumber;
	}
	public String getSpeed() {
		return Speed;
	}
	public void setSpeed(String speed) {
		Speed = speed;
	}
	public String getHoleSize() {
		return HoleSize;
	}
	public void setHoleSize(String holeSize) {
		HoleSize = holeSize;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
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
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public Date getDateOrder() {
		return DateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		DateOrder = dateOrder;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean status) {
		Status = status;
	}
	public Integer getCost() {
		return Cost;
	}
	public void setCost(Integer cost) {
		Cost = cost;
	}
	public String getPayment() {
		return Payment;
	}
	public void setPayment(String payment) {
		Payment = payment;
	}
	
	
	
	
	public QuotesDTO(int iD_Order, int iD_Product, String productName,
			String floorNumber, String speed, String holeSize, String fullName,
			String address, String email, String telephone, Date dateOrder,
			Boolean status, Integer cost, String payment, String weight) {
		super();
		ID_Order = iD_Order;
		ID_Product = iD_Product;
		ProductName = productName;
		FloorNumber = floorNumber;
		Speed = speed;
		HoleSize = holeSize;
		FullName = fullName;
		Address = address;
		Email = email;
		Telephone = telephone;
		DateOrder = dateOrder;
		Status = status;
		Cost = cost;
		Payment = payment;
		Weight = weight;
	}
	public QuotesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}