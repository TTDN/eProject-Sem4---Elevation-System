package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.DateTimeAtCompleted;

import dto.ProductDTO;
import dto.QuotesDTO;;

public class QuotesDAO {
	
	public boolean InsertOrder (QuotesDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Quotes (ID_Product,ProductName,FloorNumber,Speed,HoleSize,FullName,Address,Email,Telephone,DateOrder,Status,Cost,Payment) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, o.getID_Product());
			ps.setString(2, o.getProductName());
			ps.setString(3, o.getFloorNumber());
			ps.setString(4, o.getSpeed());
			ps.setString(5, o.getHoleSize());
			ps.setString(6, o.getFullName());
			ps.setString(7, o.getAddress());
			ps.setString(8, o.getEmail());
			ps.setString(9, o.getTelephone());
			ps.setDate(10, (Date) o.getDateOrder());
			ps.setBoolean(11, true);
			ps.setInt(12, 12);
			ps.setString(13, o.getPayment());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateOrder(QuotesDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Quotes SET ProductName=?,FloorNumber=?,Speed=?,HoleSize=?,FullName=?,Address=?,Email=?,Telephone=?,DateOrder=?,Status=?,Cost=?,Payment=? WHERE ID_Order=?");
			ps.setString(1, o.getProductName());
			ps.setString(2, o.getFloorNumber());
			ps.setString(3, o.getSpeed());
			ps.setString(4, o.getHoleSize());
			ps.setString(5, o.getFullName());
			ps.setString(6, o.getAddress());
			ps.setString(7, o.getEmail());
			ps.setString(8, o.getTelephone());
			ps.setDate(9, (Date) o.getDateOrder());
			ps.setBoolean(10, o.getStatus());
			ps.setInt(11, o.getCost());
			ps.setString(12, o.getPayment());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteOrder(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Oder WHERE ID_Order = ?");
			ps.setInt(1, id);

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<QuotesDTO> FindAllOrder() {
		ArrayList<QuotesDTO> listo = new ArrayList<QuotesDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Quotes ");
			while (rs.next()) {
				
				QuotesDTO o = new QuotesDTO();
				o.setID_Order(rs.getInt("ID_Order"));
				o.setID_Product(rs.getInt("ID_Product"));
				o.setProductName(rs.getString("ProductName"));
				o.setFloorNumber(rs.getString("FloorNumber"));
				o.setSpeed(rs.getString("Speed"));
				o.setHoleSize(rs.getString("HoleSize"));
				o.setFullName(rs.getString("FullName"));
				o.setAddress(rs.getString("Address"));
				o.setEmail(rs.getString("Email"));
				o.setTelephone(rs.getString("Telephone"));
				o.setDateOrder (rs.getDate("DateOrder"));
				o.setStatus(rs.getBoolean("Status"));
				o.setCost(rs.getInt("Cost"));
				o.setPayment(rs.getString("Payment"));
				o.setWeight(rs.getString("Weight"));
				
				listo.add(o);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listo;
	}
	
	public QuotesDTO FindIdQuotesDTO(int id) {

		QuotesDTO o = new QuotesDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Quotes WHERE ID_Order = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				o.setID_Order(rs.getInt("ID_Order"));
				o.setProductName(rs.getString("ProductName"));
				o.setFloorNumber(rs.getString("FloorNumber"));
				o.setSpeed(rs.getString("Speed"));
				o.setHoleSize(rs.getString("HoleSize"));
				o.setFloorNumber(rs.getString("FullName"));
				o.setAddress(rs.getString("Address"));
				o.setEmail(rs.getString("Email"));
				o.setTelephone(rs.getString("Telephone"));
				o.setDateOrder (rs.getDate("DateOrder"));
				o.setStatus(rs.getBoolean("Status"));
				o.setCost(rs.getInt("Cost"));
				o.setPayment(rs.getString("Payment"));
				o.setWeight(rs.getString("Weight"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	
	
	public ArrayList<ProductDTO> FindAllProduct() {
		ArrayList<ProductDTO> listpr = new ArrayList<ProductDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product ");
			while (rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setID_Product(rs.getInt("ID_Product"));
				p.setName(rs.getString("Name"));
				p.setImages(rs.getString("Images"));
				p.setDescription(rs.getString("Description"));
				p.setStatus(rs.getBoolean("Status"));
				p.setContents(rs.getString("Contents"));
				listpr.add(p);
			
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listpr;
	}
	public static void main(String[] args) {
		QuotesDAO q= new QuotesDAO();
		ArrayList<ProductDTO> list = q.FindAllProduct();
		System.out.println(list);
		
	}
	
	
	
	
	public boolean InsertQuotes (QuotesDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Quotes (ID_Product,ProductName,Weight,FloorNumber,Speed,HoleSize,FullName,Address,Email,Telephone,DateOrder,Payment) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, o.getID_Product());
			ps.setString(2, o.getProductName());
			ps.setString(3, o.getWeight());
			ps.setString(4, o.getFloorNumber());
			ps.setString(5, o.getSpeed());
			ps.setString(6, o.getHoleSize());
			ps.setString(7, o.getFullName());
			ps.setString(8, o.getAddress());
			ps.setString(9, o.getEmail());
			ps.setString(10, o.getTelephone());
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			java.util.Date date = new java.util.Date();
//			date = dateFormat.format(date);
			Calendar calendar = Calendar.getInstance();

			java.util.Date currentDate = calendar.getTime();

			java.sql.Date date = new java.sql.Date(currentDate.getTime());
			ps.setDate(11, date);
			
			ps.setString(12, o.getPayment());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}