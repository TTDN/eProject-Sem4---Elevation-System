package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import dto.Product;

@ManagedBean
public class C {
	// testing for <p:dataTable>
	
	private List<Product> productList;
	
	public C() {
		// when load this bean, init value for productList
		// call BO to get all products in db		
		// for test
		productList = new ArrayList<Product>();
		productList.add(new Product(1,"P1", 100));
		productList.add(new Product(2,"P2", 200));
		productList.add(new Product(3,"P3", 300));
		productList.add(new Product(4,"P4", 400));
		productList.add(new Product(5,"P5", 500));
		productList.add(new Product(6,"P6", 600));
		productList.add(new Product(7,"P7", 700));
		productList.add(new Product(8,"P8", 800));
//		productList.add(new Product(9,"P9", 900));
//		productList.add(new Product(10,"P10", 1000));
//		productList.add(new Product(11,"P11", 1100));
//		productList.add(new Product(12,"P12", 1200));
	}
	

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public int getSize() {
		return productList.size();
	}
	
	

}
