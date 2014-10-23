package dto;

public class ProjectDTO {
	private int ID_Project;
	private String Name;
	private String Contents;
	private String Images;
	public ProjectDTO(int iD_Project, String name, String contents,
			String images, String description) {
		super();
		ID_Project = iD_Project;
		Name = name;
		Contents = contents;
		Images = images;
		Description = description;
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
	private String Description;
	public int getID_Project() {
		return ID_Project;
	}
	public void setID_Project(int iD_Project) {
		ID_Project = iD_Project;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}

	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + ID_Project
				+ ", " + Description
				+ ", " + Images
				+ ", " + Name
				+ ", " + Contents
				+ ")";
	}
	

}
