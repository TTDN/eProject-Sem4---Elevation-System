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
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ProductDAO (ID_Type,Name,Images,Description,Status,Contents) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, p.getID_Type());
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

	public boolean UpdateProduct(ProductDTO p) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE ProductDAO SET ID_Type=?,Name=?,Images=?,Description=?,Status=?,Contents=? WHERE ID_Product=?");
			ps.setInt(1, p.getID_Type());
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

	public List<ProductDTO> FindAllProduct() {

		ArrayList<ProductDTO> listproduct = new ArrayList<ProductDTO>();

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ProductDTO");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ProductDTO p = new ProductDTO();
				p.setID_Type(rs.getInt("ID_Type"));
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
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ProductDTO WHERE Name = ?");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ProductDTO p = new ProductDTO();
				p.setID_Type(rs.getInt("ID_Type"));
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