package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.admin;

public class admimDAO {
	public boolean insertadmin(admin ad) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO admin(username,password,phone,ngaysinh,email,diachi) VALUES(?,?,?,?,?,?)");
			ps.setString(1, ad.getUsername());
			ps.setString(2, ad.getPassword());
			ps.setInt(3, ad.getPhone());
			ps.setDate(4, new java.sql.Date(ad.getNgaysinh().getTime()));
			ps.setString(5, ad.getEmail());
			ps.setString(6, ad.getDiachi());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		admimDAO adao = new admimDAO();
		admin ad = new admin();
		ad.setUsername("sdfsðsf");
		ad.setPassword("ðasa2");
		ad.setPhone(34324);
		ad.setEmail("sdfsdafsaf");
		ad.setDiachi("sdfsdfds");

		adao.insertadmin(ad);
		System.out.println("Record is delete to DBUSER table!");
	}

	public boolean updateadmin(admin ad) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE admin SET username=?,password=?,phone=?,ngaysinh=?,email=?,diachi=? WHERE iduser=?");
			ps.setString(1, ad.getUsername());
			ps.setString(2, ad.getPassword());
			ps.setInt(3, ad.getPhone());
			ps.setDate(4, new java.sql.Date(ad.getNgaysinh().getTime()));
			ps.setString(5, ad.getEmail());
			ps.setString(6, ad.getDiachi());
			ps.setInt(7, ad.getIduser());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteadmin(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM admin WHERE iduser = ?");
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

	public ArrayList<admin> findalladmin() {
		ArrayList<admin> listad = new ArrayList<admin>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM admin");
			while (rs.next()) {
				admin ad = new admin();
				ad.setIduser(rs.getInt("iduser"));
				ad.setUsername(rs.getString("username"));
				ad.setPassword(rs.getString("password"));
				ad.setPhone(rs.getInt("phone"));
				ad.setNgaysinh(rs.getDate("ngaysinh"));
				ad.setEmail(rs.getString("email"));
				ad.setDiachi(rs.getString("diachi"));
				listad.add(ad);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listad;
	}

	public admin findidadmin(int id) {
		admin ad = new admin();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM admin WHERE iduser = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ad.setIduser(rs.getInt("iduser"));
				ad.setUsername(rs.getString("username"));
				ad.setPassword(rs.getString("password"));
				ad.setPhone(rs.getInt("phone"));
				ad.setNgaysinh(rs.getDate("ngaysinh"));
				ad.setEmail(rs.getString("email"));
				ad.setDiachi(rs.getString("diachi"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ad;
	}
}
