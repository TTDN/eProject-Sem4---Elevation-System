package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ReplyComplaint;

public class ReplyComplaintDAO {
	public boolean InsertReplyComplaint(ReplyComplaint rp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ReplyComplaint (ID_Complaint,Contents) VALUES(?,?)");
			ps.setInt(1, rp.getID_Complaint());
			ps.setString(2, rp.getContents());
		
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean updateReplyComplaint(ReplyComplaint rc) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Complaint SET ID_Complaint=?,Contents=? WHERE ID_ReplyComplaint=?");
			ps.setInt(1, rc.getID_Complaint());
			ps.setString(2, rc.getContents());
			ps.setInt(3,rc.getID_Complaint());
		

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteReplyComplaint(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM ReplyComplaint WHERE ID_ReplyComplaint = ?");
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

	public ArrayList<ReplyComplaint> findallReplyComplaint() {
		ArrayList<ReplyComplaint> listrc = new ArrayList<ReplyComplaint>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ReplyComplaint");
			while (rs.next()) {
				ReplyComplaint rc = new ReplyComplaint();
				rc.setID_ReplyComplaint(rs.getInt("ID_ReplyComplaint"));
				rc.setID_Complaint(rs.getInt("ID_Complaint"));
				rc.setContents(rs.getString("Contents"));
				
				
				
				listrc.add(rc);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listrc;
	}

	public ReplyComplaint findidReplyComplaint(int id) {
		ReplyComplaint rc = new ReplyComplaint();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ReplyComplaint WHERE ID_ReplyComplaint = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				rc.setID_ReplyComplaint(rs.getInt("ID_ReplyComplaint"));
				rc.setID_Complaint(rs.getInt("ID_Complaint"));
				rc.setContents(rs.getString("Contents"));
				
				
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return rc;
	}
}
