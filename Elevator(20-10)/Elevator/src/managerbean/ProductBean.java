package managerbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import dao.ProductDAO;
import dao.ProjectDAO;
import dto.ProductDTO;
import dto.ProjectDTO;
import util.HttpUtil;

@ManagedBean(name ="ProductBean")

@SessionScoped
public class ProductBean {
	public static final long serialVersionUID = 1L;
	public List<ProductDTO> getListproduct() {
		List<ProductDTO> ls = new ProductDAO().FindAll();
		return ls;
	}
	private UploadedFile file;

	
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	private ProductDTO p = new ProductDTO();

	public ProductDTO getP() {
		return p;
	}

	public void setP(ProductDTO p) {
		this.p = p;
	}

	public ProductDTO getProductById()
	{
		int id=Integer.valueOf(String.valueOf(HttpUtil.getFromSession("id")));
		return ProductDAO.findidProductDTO(id);

	}
	public  String View (int id)
	{
		
	HttpUtil.putToSession("id",id);
	return "/Product_Details";
	}


	public ProductBean() {

	}
//test

	// Session InsertProject
		public String getSessionInsertProduct() {
			return String.valueOf(HttpUtil
					.getFromSession("InsertProjectNotification"));
		}

		public String DestroySessionInsertProduct() {
			HttpUtil.putToSession("InsertProjectNotification", null);
			return null;
		}

		// Session UpdateProject
		public String getSessionUpdateProduct() {
			return String.valueOf(HttpUtil
					.getFromSession("InsertProjectNotification"));
		}

		public String DestroySessionUpdateProduct() {
			HttpUtil.putToSession("InsertProjectNotification", null);
			return null;
		}

		// Session IDProject
		public static String getSessionIDPrduct() {
			return String.valueOf(HttpUtil.getFromSession("IDProduct"));
		}

		public String DestroySessionIDProduct() {
			HttpUtil.putToSession("IDProduct", null);
			return null;
		}

		
		

		public String EditProduct() {

			//p.setID_Project(Integer.parseInt(getSessionIDProject()));
		
			System.out.println(p.getName());
			Boolean b = ProductDAO.UpdateProduct(p);
			if (b) {
				HttpUtil.putToSession("UpdateProjectNotification",
						"Change project information successful!");
			} else {
				HttpUtil.putToSession("UpdateProjectNotification",
						"An error occurred, check and try again.");
			}

			return null;
		}

		public String GetIDProduct(int id) {

			HttpUtil.putToSession("IDProduct", id);
			return "EditProduct";
		}

		public ProductDTO getPrByID() {
			return p;
		}

		public String Edit(int id){
			p = ProductDAO.findidProductDTO(id);
			return "EditProduct";
		}
		
		public String AddProduct() throws IOException {
			String path = FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("//resources//");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
			String name = fmt.format(new Date())+"_"+file.getFileName();
			System.out.println(path);
			File filesave = new File(path + "/images/product/" + name);
			System.out.println(path + "/images/product/" + name);
			InputStream is =file.getInputstream();
			OutputStream out = new FileOutputStream(filesave);
			byte buf[] = new byte[2048];
			int len;
			while ((len = is.read(buf)) > 0)
				out.write(buf, 0, len);
			is.close();
			out.close();
			
			p.setImages(name);
			Boolean b = ProductDAO.InsertProduct(p);
			/*if (b) {
				HttpUtil.putToSession("InsertProjectNotification",
						"Add project successful!");
			} else {
				HttpUtil.putToSession("InsertProjectNotification",
						"An error occurred, check and try again.");
			}*/


		return "thank.xhtml";
	}
		





}




