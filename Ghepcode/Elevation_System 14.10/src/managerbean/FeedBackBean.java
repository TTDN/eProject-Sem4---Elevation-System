package managerbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import dao.FeedbackDAO;
import dto.FeedbackDTO;
@ManagedBean(name ="insertfeedback")
public class FeedBackBean {
	public static final long serialVersionUID = 1L;
	private FeedbackDTO fb= new FeedbackDTO();
	private List<FeedbackDTO> listFeddback;
	public FeedbackDTO getfb() {
		return fb;
	}
	public void setfb(FeedbackDTO fb) {
		this.fb = fb;
	}
	public List<FeedbackDTO> getListFeddback() {
		return listFeddback;
	}
	public void setListFeddback(List<FeedbackDTO> listFeddback) {
		this.listFeddback = listFeddback;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FeedBackBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String insertFB() throws ClassNotFoundException, SQLException {
		FeedbackDAO.InsertFeedback(fb);
			return "register-success?faces-redirect=true";
		}
}
