package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.Product;
import dto.User;

@ManagedBean(name="a")
@SessionScoped
public class A {
	
	private List<Product> productList;
	
	public A() {
		// when load this bean, init value for productList
		// call BO to get all products in db
		
		// for test
		productList = new ArrayList<Product>();
		productList.add(new Product(1,"P1", 100));
		productList.add(new Product(2,"P2", 200));
		productList.add(new Product(3,"P3", 300));		
	}

	public List<Product> getProductList() {
		return productList;
	}	
	
	
	public String deleteProduct(Product p) {
		// go to database and delete
		
		// for test
		System.out.println("Deleting..."  + p.getId());
		productList.remove(p);
		return null;
	}
	
//	public String deleteProduct(long id) {
//		System.out.println(id);
//		return null;
//	}
	
	// for adding product
	private Product addingProduct = new Product();
	
	public String addProduct() {
		// go to db and add
		
		// for test
		productList.add(addingProduct);
		return null;
	}

	public Product getAddingProduct() {
		return addingProduct;
	}

	public void setAddingProduct(Product addingProduct) {
		this.addingProduct = addingProduct;
	}
	
	// for editing product
	private boolean editMode = false;
	private Product edittingProduct;

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}	
	
	public Product getEdittingProduct() {
		return edittingProduct;
	}

	public void setEdittingProduct(Product edittingProduct) {
		this.edittingProduct = edittingProduct;
	}

	public String switchToEditMode(Product p) {
		editMode = true;
		edittingProduct = p;
		return null;
	}
	
	public boolean isEditingProduct(Product x) {		
		if (editMode && edittingProduct != null && (edittingProduct.getId()==x.getId())) {
			return true;
		}
		return false;
	}
	
	public String save(Product x) {
		// save value of edittingProduct to db		
		//for test, just print out
		System.out.println(x);		
		editMode = false;
		return null;
	}
	
	
	
	
	
	
	
}
