package managerbean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import util.HttpUtil;
import dao.ComplaintDAO;
import dao.FeedbackDAO;
import dao.UserDAO;
import dto.ComplaintDTO;
import dto.FeedbackDTO;
import dto.UserDTO;

@ManagedBean(name = "complaintBean")

@SessionScoped
public class ComplaintBean {

	public static final long serialVersionUID = 1L;
	private ComplaintDTO cpl = new ComplaintDTO();
	private List<ComplaintDTO> listComplaint;
	public List<ComplaintDTO> lcpl;
	public ComplaintDTO getCpl() {
		return cpl;
	}

	public void setCpl(ComplaintDTO cpl) {
		this.cpl = cpl;
	}

	public List<ComplaintDTO> getListComplaint() {
		return listComplaint;
	}

	public void setListComplaint(List<ComplaintDTO> listComplaint) {
		this.listComplaint = listComplaint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ComplaintBean(ComplaintDTO cpl, List<ComplaintDTO> listComplaint) {
		super();
		this.cpl = cpl;
		this.listComplaint = listComplaint;
	}

	public ComplaintBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String insertCPL() {
		if (ComplaintDAO.InsertComplaint(cpl) && UserBean.getSessionId()!= null) {
			return "thank?faces-redirect=true";
			
		} else {
			return "Login?faces-redirect=true";
		}

	}
	
	

	public List<ComplaintDTO> getListComplaintDTOs() {
		lcpl = new ComplaintDAO().findallComplaint();
		return lcpl;
	}
	
	public List<UserDTO> getLu(){
		List<UserDTO> us = new UserDAO().findid(lcpl);
		
		
		return us;
	}
	

	public String View (int id){
		HttpUtil.putToSession("id", id);
		return "/Detail_Complaint";
	}
	public ComplaintDTO getComplaintById(){
		int id = Integer.valueOf(String.valueOf(HttpUtil.getFromSession("id")));
		return ComplaintDAO.findidComplaint(id);
	}

}
