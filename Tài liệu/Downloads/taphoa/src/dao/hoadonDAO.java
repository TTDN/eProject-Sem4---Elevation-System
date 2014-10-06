package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.hoadon;

public class hoadonDAO {
	public boolean inserthoadon(hoadon hd) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO hoadon(idct,ngay,tongtien) VALUES(?,?,?)");
			ps.setInt(1, hd.getIdct());
			ps.setDate(2, hd.getNgay());
			ps.setInt(3, hd.getTongtien());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatehoadon(hoadon hd) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE hoadon SET idct=?,ngay=?,tongtien=? WHERE idhd=?");
			ps.setInt(1, hd.getIdct());
			ps.setDate(2, hd.getNgay());
			ps.setInt(3, hd.getTongtien());
			ps.setInt(4, hd.getIdhd());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deletehoadon(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM hoadon WHERE idhd = ?");
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

	public ArrayList<hoadon> findallhoadon() {
		ArrayList<hoadon> listhd = new ArrayList<hoadon>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM hoadon");
			while (rs.next()) {
				hoadon hd = new hoadon();
				hd.setIdhd(rs.getInt("idhd"));
				hd.setIdct(rs.getInt("idct"));
				hd.setNgay(rs.getDate("ngay"));
				hd.setTongtien(rs.getInt("tongtien"));
				listhd.add(hd);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listhd;
	}

	public hoadon findidcthoadon(int id) {
		hoadon hd = new hoadon();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=taphoa;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM hoadon WHERE idhd=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				hd.setIdhd(rs.getInt("idhd"));
				hd.setIdct(rs.getInt("idct"));
				hd.setNgay(rs.getDate("ngay"));
				hd.setTongtien(rs.getInt("tongtien"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return hd;
	}
}