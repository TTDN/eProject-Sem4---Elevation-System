package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.FeedbackDTO;

public class FeedbackDAO {
	public static boolean InsertFeedback(FeedbackDTO fb) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Feedback (Name,Email,Description,Satisfying,Contents,Problem,Improvement) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getEmail());
			ps.setString(3, fb.getDescription());
			ps.setString(4, fb.getSatisfying());
			ps.setString(5, fb.getContents());
			ps.setString(6, fb.getProblem());
			ps.setString(7, fb.getImprovement());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public static boolean updateFeedback(FeedbackDTO fb) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Feeback SET Name=?,Email=?,Description=?,Satisfying=?,Contents=?,Problem=?,Improvement=? WHERE ID_Feebback=?");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getEmail());
			ps.setString(3, fb.getDescription());
			ps.setString(4, fb.getSatisfying());
			ps.setString(5, fb.getContents());
			ps.setString(6, fb.getProblem());
			ps.setString(7, fb.getImprovement());
			ps.setInt(8, fb.getID_Feedback());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteFeedback(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Feedback WHERE ID_Feebback = ?");
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

	public ArrayList<FeedbackDTO> findallUserDTO() {
		ArrayList<FeedbackDTO> listus = new ArrayList<FeedbackDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Feedback");
			while (rs.next()) {
				FeedbackDTO fb = new FeedbackDTO();
				fb.setID_Feedback(rs.getInt("ID_Feedback"));
				fb.setName(rs.getString("Name"));
				fb.setEmail(rs.getString("Email"));
				fb.setDescription(rs.getString("Description"));
				fb.setSatisfying(rs.getString("Satisfying"));
				fb.setContents(rs.getString("Contents"));
				fb.setProblem(rs.getString("Problem"));
				fb.setImprovement(rs.getString("Improvement"));
				listus.add(fb);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listus;
	}

	
	public FeedbackDTO  findallFeedbackDTO() {
		FeedbackDTO listus = new FeedbackDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Feedback");
			while (rs.next()) {
				FeedbackDTO fb = new FeedbackDTO();
				fb.setID_Feedback(rs.getInt("ID_Feedback"));
				fb.setName(rs.getString("Name"));
				fb.setEmail(rs.getString("Email"));
				fb.setDescription(rs.getString("Description"));
				fb.setSatisfying(rs.getString("Satisfying"));
				fb.setContents(rs.getString("Contents"));
				fb.setProblem(rs.getString("Problem"));
				fb.setImprovement(rs.getString("Improvement"));
			
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listus;
	}
	
	
	public static FeedbackDTO findIdFeefback(int id) {
		FeedbackDTO fb = new FeedbackDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Feedback WHERE ID_Feedback = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				fb.setID_Feedback(rs.getInt("ID_Feedback"));
				fb.setName(rs.getString("Name"));
				fb.setEmail(rs.getString("Email"));
				fb.setDescription(rs.getString("Description"));
				fb.setSatisfying(rs.getString("Satisfying"));
				fb.setContents(rs.getString("Contents"));
				fb.setProblem(rs.getString("Problem"));
				fb.setImprovement(rs.getString("Improvement"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return fb;
	}

}
