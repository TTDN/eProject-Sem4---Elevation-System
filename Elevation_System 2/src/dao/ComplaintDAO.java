package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ComplaintDTO;;

public class ComplaintDAO {
	public boolean InsertComplaint(ComplaintDTO cp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Complaint (ID_User,Contents) VALUES(?,?)");
		
			ps.setInt(1, cp.getID_User());
			ps.setString(2, cp.getContents());
		
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean updateComplaint(ComplaintDTO cp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Complaint SET ID_User=?,Contents=? WHERE ID_Complaint=?");
	
			ps.setInt(1, cp.getID_User());
			ps.setString(2, cp.getContents());
			ps.setInt(3,cp.getID_Complaint());
		

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteComplaint(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Complaint WHERE ID_Complaint = ?");
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

	public ArrayList<ComplaintDTO> findallComplaint() {
		ArrayList<ComplaintDTO> listcp = new ArrayList<ComplaintDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Complaint");
			while (rs.next()) {
				ComplaintDTO cp = new ComplaintDTO();
				cp.setID_Complaint(rs.getInt("ID_Complaint"));
				cp.setID_User(rs.getInt("ID_User"));
				cp.setContents(rs.getString("Contents"));
				
				
				
				listcp.add(cp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listcp;
	}

	public ComplaintDTO findidComplaint(int id) {
		ComplaintDTO ad = new ComplaintDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Complaint WHERE ID_Complaint = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ad.setID_Complaint(rs.getInt("ID_Complaint"));
				ad.setID_User(rs.getInt("ID_User"));
				ad.setContents(rs.getString("Contents"));
				
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ad;
	}


	
	
}
