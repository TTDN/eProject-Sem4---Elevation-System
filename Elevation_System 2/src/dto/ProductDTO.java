package dto;

public class ProductDTO {
private int ID_Project;
private int ID_Order;
private int ID_Type;
private String Name;
private String Images;
private String Description;
private boolean Status;
private String Contents;
public int getID_Project() {
	return ID_Project;
}
public void setID_Project(int iD_Project) {
	ID_Project = iD_Project;
}
public int getID_Order() {
	return ID_Order;
}
public void setID_Order(int iD_Order) {
	ID_Order = iD_Order;
}
public int getID_Type() {
	return ID_Type;
}
public void setID_Type(int iD_Type) {
	ID_Type = iD_Type;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getImages() {
	return Images;
}
public void setImages(String images) {
	Images = images;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public boolean isStatus() {
	return Status;
}
public void setStatus(boolean status) {
	Status = status;
}
public String getContents() {
	return Contents;
}
public void setContents(String contents) {
	Contents = contents;
}
public ProductDTO(int iD_Project, int iD_Order, int iD_Type, String name,
		String images, String description, boolean status, String contents) {
	super();
	ID_Project = iD_Project;
	ID_Order = iD_Order;
	ID_Type = iD_Type;
	Name = name;
	Images = images;
	Description = description;
	Status = status;
	Contents = contents;
}
public ProductDTO() {
	super();
	// TODO Auto-generated constructor stub
}

}
