package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.sanpham;

public class sanphamDao {
	public boolean insertsanpham(sanpham sp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO sanpham(tensp,hinhanh,gia,soluong,iddm) VALUES(?,?,?,?,?)");
			ps.setString(1, sp.getTensp());
			ps.setString(2, sp.getHinhanh());
			ps.setInt(3, sp.getGia());
			ps.setInt(4, sp.getSoluong());
			ps.setInt(5, sp.getIddm());

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
		sanphamDao spdao = new sanphamDao();
		sanpham sp = new sanpham();
		sp.setTensp("fdg4");
		sp.setHinhanh("e23432e");
		sp.setGia(23213);
		sp.setSoluong(120);
		sp.setIddm(2);
		spdao.insertsanpham(sp);
		System.out.println("Record is insert to DBUSER table!");
	}

	public boolean updatesanpham(sanpham sp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE sanpham SET tensp=?,hinhanh=?,gia=?,soluong=?,iddm=? WHERE idsp=?");
			ps.setString(1, sp.getTensp());
			ps.setString(2, sp.getHinhanh());
			ps.setInt(3, sp.getGia());
			ps.setInt(4, sp.getSoluong());
			ps.setInt(5, sp.getIddm());
			ps.setInt(6, sp.getIdsp());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletesanpham(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM sanpham WHERE idsp = ?");
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

	public ArrayList<sanpham> findallsanpham() {
		ArrayList<sanpham> listsp = new ArrayList<sanpham>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM sanpham");
			while (rs.next()) {
				sanpham sp = new sanpham();
				sp.setIdsp(rs.getInt("idsp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setHinhanh(rs.getString("hinhanh"));
				sp.setGia(rs.getInt("gia"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setIddm(rs.getInt("iddm"));
				listsp.add(sp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listsp;
	}

	public sanpham findidsanpham(int id) {
		sanpham sp = new sanpham();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM sanpham WHERE idsp=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sp.setIdsp(rs.getInt("idsp"));
				sp.setTensp(rs.getString("tensp"));
				sp.setHinhanh(rs.getString("hinhanh"));
				sp.setGia(rs.getInt("gia"));
				sp.setSoluong(rs.getInt("soluong"));
				sp.setIddm(rs.getInt("iddm"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return sp;
	}
}
