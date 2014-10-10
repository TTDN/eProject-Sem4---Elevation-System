package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.QuotesDTO;;

public class QuotesDAO {
	
	public boolean InsertOrder (QuotesDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Quotes (ProductName,FloorNumber,Speed,HoleSize,FullName,Address,Email,Telephone,DateOrder,Status,Cost,Payment) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
		
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
	
	public boolean UpdateOrder(QuotesDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Quotes SET ProductName=?,FloorNumber=?,Speed=?,HoleSize=?,FullName=?,Address=?,Email=?,Telephone=?,DateOrder=?,Status=?,Cost=?,Payment=? WHERE ID_Quotes=?");
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Quotes");
			while (rs.next()) {
				
				QuotesDTO o = new QuotesDTO();
				o.setID_Quotes(rs.getInt("ID_Quotes"));
				
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
					.prepareStatement("SELECT * FROM Quotes WHERE ID_Quotes = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				o.setID_Quotes(rs.getInt("ID_Quotes"));
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
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
}