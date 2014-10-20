package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ComplaintDTO;
import dto.UserDTO;

public class UserDAO {

	public static boolean InsertUser(UserDTO us) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
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
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
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
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
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

	public static ArrayList<UserDTO> FindAllUserDTO() {
		System.out.println("Vào find all. ");
		ArrayList<UserDTO> listus = new ArrayList<UserDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			System.out.println("Connetion xong.");
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
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM [User] WHERE ID_User = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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

	public static UserDTO findUser(String username) {

		UserDTO us = new UserDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM [User] WHERE UserName = ?");

			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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

	public static Boolean FindByUsername(String username, String password) {

		List<UserDTO> list = FindAllUserDTO();

		for (UserDTO u : list) {
			if (u.getUserName().equals(username)
					&& u.getPassWord().equals(password)) {
				return true;
			}

			System.out.println(u.getUserName());
			System.out.println(u.getPassWord());
		}
		return false;

		// UserDTO us = new UserDTO();
		// try {
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Connection conn = (Connection)
		// DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
		// PreparedStatement ps =
		// conn.prepareStatement("SELECT * FROM [User] WHERE UserName = ? AND PassWord = ?");
		// ps.setString(1, username);
		// ps.setString(2, password);
		// ResultSet rs = ps.executeQuery();
		// if (rs.getString("UserName") == null) {
		// while (rs.next()) {
		// us.setID_User(rs.getInt("ID_User"));
		// us.setUserName(rs.getString("UserName"));
		// us.setPassWord(rs.getString("PassWord"));
		// us.setFullName(rs.getString("FullName"));
		// us.setEmail(rs.getString("Email"));
		// us.setAddress(rs.getString("Address"));
		// us.setCompany(rs.getString("Company"));
		// }
		// return true;
		// }else{
		// return false;
		// }
		// } catch (SQLException | ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		// return false;
	}

	public static ArrayList<UserDTO> findid(List<ComplaintDTO> cpl) {
		ArrayList<UserDTO> listus = new ArrayList<UserDTO>();
		for (ComplaintDTO c : cpl) {
			UserDTO us = new UserDTO();

			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection conn = (Connection) DriverManager
						.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM [User] WHERE ID_User = ?");
				ps.setInt(1, c.getID_User());
				System.out.println("id " + c.getID_User());

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					us.setID_User(rs.getInt("ID_User"));
					System.out.println(rs.getInt("ID_User"));
					us.setUserName(rs.getString("UserName"));

					us.setPassWord(rs.getString("PassWord"));
					us.setFullName(rs.getString("FullName"));
					us.setEmail(rs.getString("Email"));
					us.setAddress(rs.getString("Address"));
					us.setCompany(rs.getString("Company"));
					listus.add(us);
					System.out.println("us.f" + us.getFullName());
				}
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return listus;
	}

}