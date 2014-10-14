package managerbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ProductDAO;

import dto.ProductDTO;


@ManagedBean(name ="ProductBean")
@SessionScoped
public class ProductBean {
	
public List<ProductDTO> getListproduct() {
		List<ProductDTO> ls = new ProductDAO().FindAll();
		return ls ;
	}
	public ProductBean() {
		super();
		// TODO Auto-generated constructor stub
	}
}
