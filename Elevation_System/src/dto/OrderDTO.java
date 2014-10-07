package dto;
import java.util.Date;

public class OrderDTO {
	private int ID_Order;
	private int ID_User;
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
	
	public int getID_Order() {
		return ID_Order;
	}
	public void setID_Order(int iD_Order) {
		ID_Order = iD_Order;
	}
	public int getID_User() {
		return ID_User;
	}
	public void setID_User(int iD_User) {
		ID_User = iD_User;
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
	public OrderDTO(int iD_Order, int iD_User, String productName,
			String floorNumber, String speed, String holeSize, String fullName,
			String address, String email, String telephone, String name,
			Date dateOrder, Boolean status, Integer cost, String payment) {
		super();
		ID_Order = iD_Order;
		ID_User = iD_User;
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
	}
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}