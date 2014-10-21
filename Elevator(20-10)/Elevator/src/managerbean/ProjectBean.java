package managerbean;


import java.util.List;

import javax.faces.bean.ManagedBean;

import util.HttpUtil;
import dao.ProductDAO;
import dao.ProjectDAO;
import dto.ProductDTO;
import dto.ProjectDTO;

@ManagedBean(name ="ProjectBean")
public class ProjectBean {

	public static final long serialVersionUID = 1L;
	private ProjectDTO p = new ProjectDTO();
	
	
	
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
	
	public ProjectDTO getProjecttById()
	{
		int id=Integer.valueOf(String.valueOf(HttpUtil.getFromSession("id")));
		return ProjectDAO.findidProject(id);

	}
	public ProjectBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public  String View (int id)
	{
		
	HttpUtil.putToSession("id",id);
	return "/Project_Details";
	}
}