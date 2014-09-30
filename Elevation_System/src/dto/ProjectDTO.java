package dto;

public class ProjectDTO {
	private int ID_Project;
	private String Name;
	private String Contents;
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
	public ProjectDTO(int iD_Project, String name, String contents) {
		super();
		ID_Project = iD_Project;
		Name = name;
		Contents = contents;
	}
	public ProjectDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
