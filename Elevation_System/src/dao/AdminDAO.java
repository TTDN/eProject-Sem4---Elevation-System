package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dto.AdminDTO;


public class AdminDAO {
	public boolean InsertAdmin(AdminDTO ad) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Admin (UserName,PassWord,FullName,Phone,Email,Address) VALUES(?,?,?,?,?,?)");
			ps.setString(1, ad.getUserName());
			ps.setString(2, ad.getPassWord());
			ps.setString(3, ad.getFullname());
			ps.setString(4,ad.getPhone());
			ps.setString(5,ad.getEmail());
			ps.setString(6,ad.getAddress());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean updateAdmin(AdminDTO ad) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Admin SET UserName=?,PassWord=?,FullName=?,Phone=?,Email=?,Address=? WHERE ID_Admin=?");
			ps.setString(1, ad.getUserName());
			ps.setString(2, ad.getPassWord());
			ps.setString(3, ad.getFullname());
			ps.setString(4,ad.getPhone());
			ps.setString(5,ad.getEmail());
			ps.setString(6,ad.getAddress());
			ps.setInt(7, ad.getID_Admin());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteAdmin(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Admin WHERE ID_Admin = ?");
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

	public ArrayList<AdminDTO> findallAdmin() {
		ArrayList<AdminDTO> listad = new ArrayList<AdminDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Admin");
			while (rs.next()) {
				AdminDTO ad = new AdminDTO();
				ad.setID_Admin(rs.getInt("ID_Admin"));
				ad.setUserName(rs.getString("UserName"));
				ad.setPassWord(rs.getString("PassWord"));
				ad.setFullname(rs.getString("FullName"));
				ad.setPhone(rs.getString("Phone"));
				ad.setEmail(rs.getString("Email"));
				ad.setAddress(rs.getString("Address"));
				
				listad.add(ad);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listad;
	}

	public AdminDTO findidAdminDTO(int id) {
		AdminDTO ad = new AdminDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Admin WHERE ID_Admin = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ad.setID_Admin(rs.getInt("ID_Admin"));
				ad.setUserName(rs.getString("UserName"));
				ad.setPassWord(rs.getString("PassWord"));
				ad.setFullname(rs.getString("FullName"));
				ad.setPhone(rs.getString("Phone"));
				ad.setEmail(rs.getString("Email"));
				ad.setAddress(rs.getString("Address"));
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ad;
	}


}
