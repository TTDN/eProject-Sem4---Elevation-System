package managerbean;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import util.HttpUtil;
import dao.FeedbackDAO;
import dto.FeedbackDTO;

@ManagedBean(name ="insertfeedback")
@SessionScoped
public class FeedBackBean {
	public static final long serialVersionUID = 1L;
	private FeedbackDTO fb= new FeedbackDTO();
	
	
	public FeedbackDTO getFb() {
		return fb;
	}
	public void setFb(FeedbackDTO fb) {
		this.fb = fb;
	}
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
		fb= new FeedbackDAO().findallFeedbackDTO();
	}
	public String insertFB() throws ClassNotFoundException, SQLException {
		FeedbackDAO.InsertFeedback(fb);
			return "thank?faces-redirect=true";
		}
	public String updateFB() throws ClassNotFoundException, SQLException {
		FeedbackDAO.updateFeedback(fb);
			return "register-success?faces-redirect=true";
		}
	
	public List<FeedbackDTO> getListFeedbackDTOs() {
		List<FeedbackDTO> ls = new FeedbackDAO().findallUserDTO();
	
	
	return ls ;
}
	
	
	
	public String View (int id){
		HttpUtil.putToSession("id", id);
		return "/Detail_FB";
	}
	public FeedbackDTO getFeedBackById(){
		int id = Integer.valueOf(String.valueOf(HttpUtil.getFromSession("id")));
		return FeedbackDAO.findIdFeefback(id);
		
	}
	
}
