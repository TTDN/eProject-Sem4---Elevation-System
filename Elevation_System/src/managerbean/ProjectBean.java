package managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.ProjectDAO;
import dto.ProjectDTO;

@ManagedBean(name ="ProjectBean")
public class ProjectBean {

	public static final long serialVersionUID = 1L;
	private ProjectDTO p = new ProjectDTO();
	private List<ProjectDTO> listproject;
	
	public ProjectDTO getP() {
		return p;
	}
	public void setP(ProjectDTO p) {
		this.p = p;
	}
	public List<ProjectDTO> getListproject() {
		return listproject;
	}
	public void setListproject(List<ProjectDTO> listproject) {
		this.listproject = listproject;
	}
	
	public List<ProjectDTO> ShowAllProject(){
		
		ProjectDAO p = new ProjectDAO();
		List<ProjectDTO> listproject = p.FindAllProject();
		
		return listproject;
		
	}	
}