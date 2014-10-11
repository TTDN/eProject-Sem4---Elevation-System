package dao;

import dto.ProductDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

	public boolean InsertProduct(ProductDTO p) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Product (Name,Images,Description,Status,Contents) VALUES(?,?,?,?,?)");

			ps.setString(1, p.getName());
			ps.setString(2, p.getImages());
			ps.setString(3, p.getDescription());
			ps.setBoolean(4, p.isStatus());
			ps.setString(5, p.getContents());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean UpdateProduct(ProductDTO p) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Product SET Name=?,Images=?,Description=?,Status=?,Contents=? WHERE ID_Product=?");

			ps.setString(2, p.getName());
			ps.setString(3, p.getImages());
			ps.setString(4, p.getDescription());
			ps.setBoolean(5, p.isStatus());
			ps.setString(6, p.getContents());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<ProductDTO> FindAll() {

		ArrayList<ProductDTO> listproduct = new ArrayList<ProductDTO>();

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				ProductDTO p = new ProductDTO();
				p.setID_Product(rs.getInt("ID_Product"));
				p.setName(rs.getString("Name"));
				p.setImages(rs.getString("Images"));
				p.setDescription(rs.getString("Description"));
				p.setStatus(rs.getBoolean("Status"));
				p.setContents(rs.getString("Contents"));
				listproduct.add(p);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listproduct;
	}

	public List<ProductDTO> FindByName(String name) {

		ArrayList<ProductDTO> listproduct = new ArrayList<ProductDTO>();

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Product WHERE Name= ?");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ProductDTO p = new ProductDTO();

				p.setName(rs.getString("Name"));
				p.setImages(rs.getString("Images"));
				p.setDescription(rs.getString("Description"));
				p.setStatus(rs.getBoolean("Status"));
				p.setContents(rs.getString("Contents"));
				listproduct.add(p);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listproduct;
	}

}