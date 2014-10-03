package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;






import dto.ContactInforDTO;
import dto.OrderDTO;;

public class OrderDAO {
	public boolean InsertOrder (OrderDTO od) {
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Order (Required,Type,Address,DateOrder,Status,PayMent) VALUES(?,?,?,?,?,?)");
			ps.setString(1, od.getRequired());
			ps.setString(2, od.getType());
			ps.setString(3, od.getAddress());
			ps.setDate(4,od.getDateOrder());
			ps.setboolean(5, od.getStatus());
			ps.setString(6,od.getPayment());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateOrder(OrderDTO od) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Order SET Required=?,Type=?,Address=?,DateOrder=?,Status=?,PayMent=? WHERE ID_Oder=?");
			ps.setString(1, od.getRequired());
			ps.setString(2, od.getType());
			ps.setString(3, od.getAddress());
			ps.setDate(4,od.getDateOrder());
			ps.setboolean(5, od.getStatus());
			ps.setString(6,od.getPayment());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteOrder(int id) {
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
	
	public ArrayList<OrderDTO> findallOrder() {
		ArrayList<OrderDTO> listod = new ArrayList<OrderDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
			while (rs.next()) {
				OrderDTO od = new OrderDTO();
				od.setID_Order(rs.getInt("ID_Order"));
				od.setID_User(rs.getInt("ID_User"));
				od.setRequired(rs.getString("Required"));
				od.setAddress(rs.getString("Address"));
				od.setType(rs.getString("Type"));
				od.setDateOrder (rs.getDate("DateOrder"));
				od.set(rs.getString("Email"));
				od.setPayment(rs.getString("Payment"));
				listod.add(od);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listod;
	}
	
	public OrderDTO findidOrderDTO(int id) {

		OrderDTO od = new OrderDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ContactInfor WHERE ID_ContactInfor = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				OrderDTO od = new OrderDTO();
				od.setID_Order(rs.getInt("ID_Order"));
				od.setID_User(rs.getInt("ID_User"));
				od.setRequired(rs.getString("Required"));
				od.setAddress(rs.getString("Address"));
				od.setType(rs.getString("Type"));
				od.setDateOrder (rs.getDate("DateOrder"));
				od.set....(rs.getString("Email"));
				od.setPayment(rs.getString("Payment"));;
				
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return od;
	}

}
