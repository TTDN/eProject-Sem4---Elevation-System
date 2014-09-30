package dto;
import java.util.Date;

public class OrderDTO {
	private int ID_Order;
	private int ID_User;
	private String Required;
	private String Type;
	private String Address;
	private Date DateOrder;
	private boolean Status;
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
	public String getRequired() {
		return Required;
	}
	public void setRequired(String required) {
		Required = required;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public Date getDateOrder() {
		return DateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		DateOrder = dateOrder;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public String getPayment() {
		return Payment;
	}
	public void setPayment(String payment) {
		Payment = payment;
	}
	public OrderDTO(int iD_Order, int iD_User, String required, String type,
			String address, Date dateOrder, boolean status, String payment) {
		super();
		ID_Order = iD_Order;
		ID_User = iD_User;
		Required = required;
		Type = type;
		Address = address;
		DateOrder = dateOrder;
		Status = status;
		Payment = payment;
	}
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
