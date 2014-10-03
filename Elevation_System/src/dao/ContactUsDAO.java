package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ContactUsDTO;

public class ContactUsDAO {

	public boolean InsertContactUs(ContactUsDTO cu) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ContactUs (Name,Talephone,CompanyName,Contents) VALUES(?,?,?,?)");
			ps.setString(1, cu.getName());
			ps.setString(2, cu.getTelephone());
			ps.setString(3, cu.getCompanyName());
			ps.setString(4, cu.getContents());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ContactUsDTO FindbyName(String name) {

		ContactUsDTO cu = new ContactUsDTO();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ContactUs WHERE Name = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cu.setID_ContactUs(rs.getInt("ID_ContactUs"));
				cu.setName(rs.getString("Name"));
				cu.setTelephone(rs.getString("Telephone"));
				cu.setCompanyName(rs.getString("CompanyName"));
				cu.setContents(rs.getString("Contents"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cu;
	}

	public ContactUsDTO FindbyCompanyName(String companyName) {

		ContactUsDTO cu = new ContactUsDTO();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ContactUs WHERE CompanyName = ?");
			ps.setString(1, companyName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				cu.setID_ContactUs(rs.getInt("ID_ContactUs"));
				cu.setName(rs.getString("Name"));
				cu.setTelephone(rs.getString("Telephone"));
				cu.setCompanyName(rs.getString("CompanyName"));
				cu.setContents(rs.getString("Contents"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cu;
	}
}