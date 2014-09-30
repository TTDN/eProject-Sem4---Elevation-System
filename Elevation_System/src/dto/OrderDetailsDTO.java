package dto;

public class OrderDetailsDTO {
private int ID_OrderDetail;
private int ID_Order;
private int ID_Product;
private int Cost;
private int Quality;
public int getID_OrderDetail() {
	return ID_OrderDetail;
}
public void setID_OrderDetail(int iD_OrderDetail) {
	ID_OrderDetail = iD_OrderDetail;
}
public int getID_Order() {
	return ID_Order;
}
public void setID_Order(int iD_Order) {
	ID_Order = iD_Order;
}
public int getID_Product() {
	return ID_Product;
}
public void setID_Product(int iD_Product) {
	ID_Product = iD_Product;
}
public int getCost() {
	return Cost;
}
public void setCost(int cost) {
	Cost = cost;
}
public int getQuality() {
	return Quality;
}
public void setQuality(int quality) {
	Quality = quality;
}
public OrderDetailsDTO(int iD_OrderDetail, int iD_Order, int iD_Product,
		int cost, int quality) {
	super();
	ID_OrderDetail = iD_OrderDetail;
	ID_Order = iD_Order;
	ID_Product = iD_Product;
	Cost = cost;
	Quality = quality;
}
public OrderDetailsDTO() {
	super();
	// TODO Auto-generated constructor stub
}

}
