package managerbean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ProductDAO;
import dto.ProductDTO;




@ManagedBean(name ="product")
@SessionScoped
public class ProductBean {
	public List<ProductDTO> getLsproduct() {
		List<ProductDTO> ls = new ProductDAO().FindAll();
		return ls ;
	}
}
