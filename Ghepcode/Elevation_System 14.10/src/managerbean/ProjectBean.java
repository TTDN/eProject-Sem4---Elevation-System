package managerbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.UploadedFile;

import util.HttpUtil;
import dao.ProductDAO;
import dao.ProjectDAO;
import dto.ProductDTO;
import dto.ProjectDTO;

@ManagedBean(name = "ProjectBean")
public class ProjectBean {

	public static final long serialVersionUID = 1L;
	private ProjectDTO p = new ProjectDTO();
	private List<ProjectDTO> listproject;
	private String content;
	private UploadedFile file;

	// Session InsertProject
	public String getSessionInsertProject() {
		return String.valueOf(HttpUtil
				.getFromSession("InsertProjectNotification"));
	}

	public String DestroySessionInsertProject() {
		HttpUtil.putToSession("InsertProjectNotification", null);
		return null;
	}

	// Session UpdateProject
	public String getSessionUpdateProject() {
		return String.valueOf(HttpUtil
				.getFromSession("InsertProjectNotification"));
	}

	public String DestroySessionUpdateProject() {
		HttpUtil.putToSession("InsertProjectNotification", null);
		return null;
	}

	// Session IDProject
	public static String getSessionIDProject() {
		return String.valueOf(HttpUtil.getFromSession("IDProject"));
	}

	public String DestroySessionIDProject() {
		HttpUtil.putToSession("IDProject", null);
		return null;
	}

	//Upload image.
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ProjectDTO getP() {
		return p;
	}

	public void setP(ProjectDTO p) {
		this.p = p;
	}

	public List<ProjectDTO> getListproject() {
		ProjectDAO p = new ProjectDAO();
		List<ProjectDTO> listproject = p.FindAllProject();

		return listproject;
	}

	public void setListproject(List<ProjectDTO> listproject) {
		this.listproject = listproject;
	}

	public String Show() {
		return null;
	}

	public String AddProject() {

		Boolean b = ProjectDAO.InsertProject(p);
		if (b) {
			HttpUtil.putToSession("InsertProjectNotification",
					"Add project successful!");
		} else {
			HttpUtil.putToSession("InsertProjectNotification",
					"An error occurred, check and try again.");
		}

		return null;
	}

	public String EditProject() {

		p.setID_Project(Integer.parseInt(getSessionIDProject()));
		Boolean b = ProjectDAO.UpdateProject(p);
		if (b) {
			HttpUtil.putToSession("UpdateProjectNotification",
					"Change project information successful!");
		} else {
			HttpUtil.putToSession("UpdateProjectNotification",
					"An error occurred, check and try again.");
		}

		return null;
	}

	public String GetIDProject(int id) {

		HttpUtil.putToSession("IDProject", id);
		return "ProjectEdit";
	}

	public ProjectDTO getProjectByID() {

		String id = getSessionIDProject();
		ProjectDTO p = ProjectDAO.FindProjectByID(Integer.parseInt(id));
		return p;
	}

	public String EditProject(int id){
		
		HttpUtil.putToSession("IDProject", id);
		return "ProjectEdit";
	}
}