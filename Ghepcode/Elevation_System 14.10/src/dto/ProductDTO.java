package dto;

public class ProductDTO {
private int ID_Product;


private String Name;
private String Images;
private String Description;
private boolean Status;
private String Contents;

public int getID_Product() {
	return ID_Product;
}
public void setID_Product(int iD_Product) {
	ID_Product = iD_Product;
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

public ProductDTO(int iD_Product, String name, String images,
		String description, boolean status, String contents) {
	super();
	ID_Product = iD_Product;
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
