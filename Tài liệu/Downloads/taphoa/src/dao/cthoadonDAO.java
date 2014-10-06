package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.cthoadon;

public class cthoadonDAO {
	public boolean insertcthoadon(cthoadon cthd) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO cthoadon(idsp,soluong,thanhtien,gia) VALUES(?,?,?,?)");
			ps.setInt(1, cthd.getIdsp());
			ps.setInt(2, cthd.getSoluong());
			ps.setInt(3, cthd.getThanhtien());
			ps.setInt(4, cthd.getGia());

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
		cthoadonDAO cthdao = new cthoadonDAO();
		cthoadon cthd = new cthoadon();
		cthd.setIdsp(1);
		cthd.setSoluong(40);
		cthd.setThanhtien(3244342);
		cthd.setGia(200);
		cthdao.insertcthoadon(cthd);
		System.out.println("Record is insert to DBUSER table!");
	}

	public boolean updatecthoadon(cthoadon cthd) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE cthoadon SET idsp=?,soluong=?,thanhtien=?,gia=? WHERE idct=?");
			ps.setInt(1, cthd.getIdsp());
			ps.setInt(2, cthd.getSoluong());
			ps.setInt(3, cthd.getThanhtien());
			ps.setInt(4, cthd.getGia());
			ps.setInt(5, cthd.getIdct());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletecthoadon(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM cthoadon WHERE idct = ?");
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

	public ArrayList<cthoadon> findallcthoadon() {
		ArrayList<cthoadon> listcthd = new ArrayList<cthoadon>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM cthoadon");
			while (rs.next()) {
				cthoadon cthd = new cthoadon();
				cthd.setIdsp(rs.getInt("idct"));
				cthd.setIdct(rs.getInt("idsp"));
				cthd.setSoluong(rs.getInt("soluong"));
				cthd.setThanhtien(rs.getInt("thanhtien"));
				cthd.setGia(rs.getInt("gia"));
				listcthd.add(cthd);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listcthd;
	}

	public cthoadon findidcthoadon(int id) {
		cthoadon cthd = new cthoadon();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM cthoadon WHERE idct=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cthd.setIdsp(rs.getInt("idct"));
				cthd.setIdct(rs.getInt("idsp"));
				cthd.setSoluong(rs.getInt("soluong"));
				cthd.setThanhtien(rs.getInt("thanhtien"));
				cthd.setGia(rs.getInt("gia"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cthd;
	}
}
