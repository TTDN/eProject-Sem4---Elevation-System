package managerbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.model.UploadedFile;

import util.HttpUtil;
import dao.ProjectDAO;
import dto.ProjectDTO;

@ManagedBean(name = "ProjectBean")
@SessionScoped
public class ProjectBean {
	  
	public static final long serialVersionUID = 1L;
	private ProjectDTO p = new ProjectDTO();
	private List<ProjectDTO> listproject;

	private String content;
	private UploadedFile file;

	public ProjectBean() {
		System.out.println(" ProjectBean()");
	}

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

	// Upload image.
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	/*public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
*/
	public ProjectDTO getP() {
		return p;
	}

	public void setP(ProjectDTO p) {
		this.p = p;
	}

	public List<ProjectDTO> getListproject() {

		List<ProjectDTO> ls = new ProjectDAO().FindAllProject();

		return ls;
	}

	public void setListproject(List<ProjectDTO> listproject) {
		this.listproject = listproject;
	}

	public String Show() {
		return null;
	}

	public String AddProject() throws IOException {
			String path = FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("//resources//");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
			String name = fmt.format(new Date())+"_"+file.getFileName();
			System.out.println(path);
			File filesave = new File(path + "/images/project/" + name);
			System.out.println(path + "/images/project/" + name);
			InputStream is =file.getInputstream();
			OutputStream out = new FileOutputStream(filesave);
			byte buf[] = new byte[2048];
			int len;
			while ((len = is.read(buf)) > 0)
				out.write(buf, 0, len);
			is.close();
			out.close();
			
			p.setImages(name);
			Boolean b = ProjectDAO.InsertProject(p);
			/*if (b) {
				HttpUtil.putToSession("InsertProjectNotification",
						"Add project successful!");
			} else {
				HttpUtil.putToSession("InsertProjectNotification",
						"An error occurred, check and try again.");
			}*/


		return "thank.xhtml";
	}

	public String EditProject() {

		// p.setID_Project(Integer.parseInt(getSessionIDProject()));

		System.out.println(p.getName());
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
		return p;
	}

	public String Edit(int id) {
		p = ProjectDAO.FindProjectByID(id);
		return "ProjectEdit";
	}

	
}