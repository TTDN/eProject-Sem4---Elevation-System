package managerbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.ProductDAO;
import dto.ProductDTO;
import util.HttpUtil;

@ManagedBean(name ="ProductBean")
@ViewScoped
public class ProductBean {

	public List<ProductDTO> getListproduct() {
		List<ProductDTO> ls = new ProductDAO().FindAll();
		return ls;
	}

	
	private ProductDTO p = new ProductDTO();

	public ProductDTO getP() {
		return p;
	}

	public void setP(ProductDTO p) {
		this.p = p;
	}

	

	public ProductBean() {

	}

	public String deleteP(ProductDTO pd) {
		ProductDAO product = new ProductDAO();
		product.DeleteProduct(pd.getID_Product());
		return "thanhcong";
	}

public String Edit(int id)
{ 
	HttpUtil.putToSession("id", id);
	return "/EditProduct";}

public String update(ProductDTO pd) {
	ProductDAO product = new ProductDAO();
	product.UpdateProduct(pd);
	return "thanhcong";
}
public ProductDTO getProductById()
{
	int id=Integer.valueOf(String.valueOf(HttpUtil.getFromSession("id")));
	return ProductDAO.findidProductDTO(id);

}
public  String View (int id)
{
	
HttpUtil.putToSession("id",id);
return "/Detail_Product";
}






}




