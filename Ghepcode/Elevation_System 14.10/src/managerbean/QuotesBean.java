package managerbean;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.ContactUsDAO;
import dao.ProductDAO;
import dao.QuotesDAO;
import dto.ContactUsDTO;
import dto.ProductDTO;
import dto.QuotesDTO;

@ManagedBean(name ="QuotesBean")
@ViewScoped
public class QuotesBean {
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public List<QuotesDTO> getListquotes() {
		List<QuotesDTO> ls = new QuotesDAO().FindAllOrder();
		return ls ;
	}
	public List<ProductDTO> getListproduct() {
		List<ProductDTO> ls = new QuotesDAO().FindAllProduct();
		return ls ;
	}
	
	private QuotesDTO qu= new QuotesDTO();
	
	
	
	
	public QuotesDTO getQu() {
		return qu;
	}
	public void setQu(QuotesDTO qu) {
		this.qu = qu;
	}
	public QuotesBean() {
		
		
	}
	
	public String addquotes() throws ClassNotFoundException, SQLException {
		qu.setID_Product(x);
		ProductDAO po = new ProductDAO();
		ProductDTO dto = po.findidProductDTO(x);
		qu.setProductName(dto.getName());
		QuotesDAO q= new QuotesDAO();
		q.InsertOrder(qu);

		return "register-success?faces-redirect=true";
	}
	
}
