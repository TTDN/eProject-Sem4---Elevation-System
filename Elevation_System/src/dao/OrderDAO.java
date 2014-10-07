package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.OrderDTO;;

public class OrderDAO {
	
	public boolean InsertOrder (OrderDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Order (ID_User,ProductName,FloorNumber,Speed,HoleSize,FullName,Address,Email,Telephone,DateOrder,Status,Cost,Payment) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, o.getID_User());
			ps.setString(2, o.getProductName());
			ps.setString(3, o.getFloorNumber());
			ps.setString(4, o.getSpeed());
			ps.setString(5, o.getHoleSize());
			ps.setString(6, o.getFullName());
			ps.setString(7, o.getAddress());
			ps.setString(8, o.getEmail());
			ps.setString(9, o.getTelephone());
			ps.setDate(10, (Date) o.getDateOrder());
			ps.setBoolean(11, o.getStatus());
			ps.setInt(12, o.getCost());
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
	
	public boolean UpdateOrder(OrderDTO o) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Order SET ID_User=?,ProductName=?,FloorNumber=?,Speed=?,HoleSize=?,FullName=?,Address=?,Email=?,Telephone=?,DateOrder=?,Status=?,Cost=?,Payment=? WHERE ID_Oder=?");
			ps.setInt(1, o.getID_User());
			ps.setString(2, o.getProductName());
			ps.setString(3, o.getFloorNumber());
			ps.setString(4, o.getSpeed());
			ps.setString(5, o.getHoleSize());
			ps.setString(6, o.getFullName());
			ps.setString(7, o.getAddress());
			ps.setString(8, o.getEmail());
			ps.setString(9, o.getTelephone());
			ps.setDate(10, (Date) o.getDateOrder());
			ps.setBoolean(11, o.getStatus());
			ps.setInt(12, o.getCost());
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
	
	public boolean DeleteOrder(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
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
	
	public ArrayList<OrderDTO> FindAllOrder() {
		ArrayList<OrderDTO> listo = new ArrayList<OrderDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
			while (rs.next()) {
				
				OrderDTO o = new OrderDTO();
				o.setID_Order(rs.getInt("ID_Order"));
				o.setID_User(rs.getInt("ID_User"));
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
	
	public OrderDTO FindIdOrderDTO(int id) {

		OrderDTO o = new OrderDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ContactInfor WHERE ID_ContactInfor = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				o.setID_Order(rs.getInt("ID_Order"));
				o.setID_User(rs.getInt("ID_User"));
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