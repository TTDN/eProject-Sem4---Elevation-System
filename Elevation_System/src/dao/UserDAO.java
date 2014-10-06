package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.UserDTO;

public class UserDAO {
	
	public static boolean InsertUser(UserDTO us) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO [User](UserName,PassWord,FullName,Email,Address,Company) VALUES(?,?,?,?,?,?)");
			ps.setString(1, us.getUserName());
			ps.setString(2, us.getPassWord());
			ps.setString(3, us.getFullName());
			ps.setString(4, us.getEmail());
			ps.setString(5, us.getAddress());
			ps.setString(6, us.getCompany());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public boolean updateUserDTO(UserDTO us) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE [User] SET UserName=?,PassWord=?,FullName=?,Email=?,Address=?,Company=? WHERE ID_User=?");
			ps.setString(1, us.getUserName());
			ps.setString(2, us.getPassWord());
			ps.setString(3, us.getFullName());
			ps.setString(4, us.getEmail());
			ps.setString(5, us.getAddress());
			ps.setString(6, us.getCompany());
			ps.setInt(7, us.getID_User());
			

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUserDTO(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM [User] WHERE ID_User = ?");
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

	public ArrayList<UserDTO> findallUserDTO() {
		ArrayList<UserDTO> listus = new ArrayList<UserDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM [User]");
			while (rs.next()) {
				UserDTO us = new UserDTO();
				us.setID_User(rs.getInt("ID_User"));
				us.setUserName(rs.getString("UserName"));
				us.setPassWord(rs.getString("PassWord"));
				us.setFullName(rs.getString("FullName"));
				us.setEmail(rs.getString("Email"));
				us.setAddress(rs.getString("Address"));
				us.setCompany(rs.getString("Company"));
				listus.add(us);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listus;
	}

	public UserDTO findidUserDTO(int id) {
		UserDTO us = new UserDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM [User] WHERE ID_User = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				us.setID_User(rs.getInt("ID_User"));
				us.setUserName(rs.getString("UserName"));
				us.setPassWord(rs.getString("PassWord"));
				us.setFullName(rs.getString("FullName"));
				us.setEmail(rs.getString("Email"));
				us.setAddress(rs.getString("Address"));
				us.setCompany(rs.getString("Company"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return us;
	}

}
