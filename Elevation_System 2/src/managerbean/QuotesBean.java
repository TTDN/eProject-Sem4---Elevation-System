package managerbean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.QuotesDAO;
import dto.QuotesDTO;

@ManagedBean(name ="QuotesBean")
public class QuotesBean {
	private String x;
	public List<QuotesDTO> getListquotes() {
		List<QuotesDTO> ls = new QuotesDAO().FindAllOrder();
		return ls ;
	}

	public QuotesBean() {
		super();
		
	}
	
}
