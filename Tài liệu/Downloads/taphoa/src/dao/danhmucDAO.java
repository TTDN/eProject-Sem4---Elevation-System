package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.danhmuc;

public class danhmucDAO {
	public boolean insertdanhmuc(danhmuc dm) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO danhmuc(tendm) VALUES(?)");
			ps.setString(1, dm.getTendm());
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
		danhmucDAO dmdao = new danhmucDAO();
		danhmuc dm = new danhmuc();
		dm.setTendm("xa bong");
		dmdao.insertdanhmuc(dm);
		System.out.println("Record is insert to DBUSER table!");
	}

	public boolean updatedanhmuc(danhmuc dm) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE danhmuc SET tendm=? WHERE iddm=?");
			ps.setString(1, dm.getTendm());
			ps.setInt(2, dm.getIddm());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletedanhmuc(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM danhmuc WHERE iddm = ?");
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

	public ArrayList<danhmuc> findalldanhmuc() {
		ArrayList<danhmuc> listdm = new ArrayList<danhmuc>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM danhmuc");
			while (rs.next()) {
				danhmuc dm = new danhmuc();
				dm.setIddm(rs.getInt("iddm"));
				dm.setTendm(rs.getString("tendm"));
				listdm.add(dm);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listdm;
	}

	public danhmuc findidanhmuc(int id) {
		danhmuc dm = new danhmuc();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM danhmuc WHERE iddm=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dm.setIddm(rs.getInt("iddm"));
				dm.setTendm(rs.getString("tendm"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dm;
	}
}
