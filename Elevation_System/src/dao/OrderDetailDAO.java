package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.OrderDetailDTO;

public class OrderDetailDAO {
	public boolean InsertOrderDetail (OrderDetailDTO od) {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Order (Required,Type,Address,DateOrder,Status,PayMent) VALUES(?,?,?,?,?,?)");
			ps.setInt(1, od.getID_Order());
			ps.setInt(2, od.getID_Product());
			ps.setInt(3, od.getCost());
			ps.setInt(4, od.getQuality());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
//	public boolean updateOrder(OrderDetailDTO od) {
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = (Connection) DriverManager
//					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
//			PreparedStatement ps = conn
//					.prepareStatement("UPDATE Order SET Required=?,Type=?,Address=?,DateOrder=?,Status=?,PayMent=? WHERE ID_Oder=?");
//			ps.setInt(1, od.getID_Order());
//			ps.setInt(2, od.getID_Product());
//			ps.setInt(3, od.getCost());
//			ps.setInt(4, od.getQuality());
//
//			int kq = ps.executeUpdate();
//			if (kq == 1) {
//				return true;
//			}
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
//	public boolean deleteOrder(int id) {
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = (Connection) DriverManager
//					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
//			PreparedStatement ps = conn
//					.prepareStatement("DELETE FROM Oder WHERE ID_Order = ?");
//			ps.setInt(1, id);
//
//			int kq = ps.executeUpdate();
//			if (kq == 1) {
//				return true;
//			}
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//	
//	public ArrayList<OrderDTO> findallOrder() {
//		ArrayList<OrderDTO> listod = new ArrayList<OrderDTO>();
//		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			Connection conn = (Connection) DriverManager
//					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
//			Statement stmt = (Statement) conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM Order");
//			while (rs.next()) {
//				OrderDTO od = new OrderDTO();
//				od.setID_Order(rs.getInt("ID_Order"));
//				od.setID_User(rs.getInt("ID_User"));
//				od.setRequired(rs.getString("Required"));
//				od.setAddress(rs.getString("Address"));
//				od.setType(rs.getString("Type"));
//				od.setDateOrder (rs.getDate("DateOrder"));
//				od.setStatus(rs.getBoolean("Status"));
//				od.setPayment(rs.getString("Payment"));
//				listod.add(od);
//			}
//		} catch (SQLException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return listod;
//	}
	
	public ArrayList<OrderDetailDTO> FindByIdOrderDTO(int id) {

		ArrayList<OrderDetailDTO> listod = new ArrayList<OrderDetailDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM OrderDetail WHERE ID_Order = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();			
			while (rs.next()) {
				OrderDetailDTO od = new OrderDetailDTO();
				od.setID_Order(rs.getInt("ID_Order"));
				od.setID_Product(rs.getInt("ID_Product"));
				od.setCost(rs.getInt("Cost"));
				od.setQuality(rs.getInt("Quality"));
				listod.add(od);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listod;
	}
}