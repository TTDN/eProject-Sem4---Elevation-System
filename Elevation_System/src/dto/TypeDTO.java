package dto;

public class TypeDTO {
	private int ID_Type;
	private String NameType;
	public int getID_Type() {
		return ID_Type;
	}
	public void setID_Type(int iD_Type) {
		ID_Type = iD_Type;
	}
	public String getNameType() {
		return NameType;
	}
	public void setNameType(String nameType) {
		NameType = nameType;
	}
	public TypeDTO(int iD_Type, String nameType) {
		super();
		ID_Type = iD_Type;
		NameType = nameType;
	}
	public TypeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
