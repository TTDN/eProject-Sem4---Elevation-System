package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.TypeDTO;;

public class TypeDAO {
	public boolean InsertType(TypeDTO tp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Type (NameType=?) VALUES(?)");
			ps.setString(1, tp.getNameType());
		
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public boolean updateType(TypeDTO tp) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Type SET NameType=? WHERE ID_Type=?");
			ps.setString(1, tp.getNameType());
			ps.setInt(2, tp.getID_Type());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteType(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Type WHERE ID_Type = ?");
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

	public ArrayList<TypeDTO> findallType() {
		ArrayList<TypeDTO> listtype = new ArrayList<TypeDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Type");
			while (rs.next()) {
				TypeDTO tp = new TypeDTO();
				tp.setID_Type(rs.getInt("ID_Type"));
				tp.setNameType(rs.getString("NameType"));
				
				
				listtype.add(tp);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listtype;
	}

	public TypeDTO findidTypeDTO(int id) {
		TypeDTO tp = new TypeDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Type WHERE ID_Type = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tp.setID_Type(rs.getInt("ID_Type"));
				tp.setNameType(rs.getString("NameType"));
			
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return tp;
	}

}
