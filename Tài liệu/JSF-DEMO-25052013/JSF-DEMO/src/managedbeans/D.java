package managedbeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

import dto.Product;

@ManagedBean
public class D {
	private LazyDataModel<Product> dataModel;

	public D() {
		dataModel = new LazyDataModel<Product>() {
			@Override
			public List<Product> load(int first, int pageSize,
					List<SortMeta> multiSortMeta, Map<String, String> filters) {
				// go to database to load only neccessary product
				// first: index of first product
				// pageSize: how many product to load
				// filters: conditions 
				
				// for test, just return a list
				List<Product> list = new ArrayList<>();
				Product p = null;
				for (int i=first+1; i<=first+pageSize; i++) {
					p = new Product(i, "P" + i, i*100);
					list.add(p);
				}
				return list;
			}
			
			@Override
			public List<Product> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, String> filters) {
				// for test, just return a list
				List<Product> list = new ArrayList<>();
				Product p = null;
				for (int i=first+1; i<=first+pageSize; i++) {
					p = new Product(i, "P" + i, i*100);
					list.add(p);
				}
				return list;
			}
			
//			getRowKey returns the id for an  Product			
			@Override
			public Object getRowKey(Product product) {
				return product.getId();
			}
			
//			getRowData gets an Product object by id
			@Override
			public Product getRowData(String rowKey) {
				long id = Long.parseLong(rowKey);
				return new Product(id, "P" + rowKey, id*100);
			}
			
			
			// need this to fix a PrimeFaces 3.5 bugs
			//https://code.google.com/p/primefaces/issues/detail?id=1544
			@Override
		    public void setRowIndex(int rowIndex) {
		        /*
		         * The following is in ancestor (LazyDataModel):
		         * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
		         */
		        if (rowIndex == -1 || getPageSize() == 0) {
		            super.setRowIndex(-1);
		        }
		        else
		            super.setRowIndex(rowIndex % getPageSize());
		    }
		};
		
		// calculate total row count
		// for test, 
		dataModel.setRowCount(100);
	}

	public LazyDataModel<Product> getDataModel() {
		return dataModel;
	}
	
	
}
