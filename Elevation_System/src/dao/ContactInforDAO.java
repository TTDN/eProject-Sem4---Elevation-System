package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dto.ContactInforDTO;;

public class ContactInforDAO {
	public boolean InsertContactInfo (ContactInforDTO cti) {
		
				
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO ContactInfor (Address,MobiPhone,TelePhone,FAX,Email,Skype,Yahoo) VALUES(?,?,?,?,?,?,?)");
			
			ps.setString(2, cti.getMobilePhone());
			ps.setString(3, cti.getTelePhone());
			ps.setString(4, cti.getFAX());
			ps.setString(5,cti.getEmail());
			ps.setString(6,cti.getSkype());
			ps.setString(7,cti.getYahoo());
		
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateContactInfor(ContactInforDTO cti) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE ContactInfor SET Address=?,Mobiphone=?,TelePhone=?,FAX=?,Email=?,Skype=?,Yahoo=? WHERE ID_ContactInfor=?");
			ps.setString(1, cti.getAddress());
			ps.setString(2, cti.getMobilePhone());
			ps.setString(3, cti.getTelePhone());
			ps.setString(4, cti.getFAX());
			ps.setString(5,cti.getEmail());
			ps.setString(6,cti.getSkype());
			ps.setString(7,cti.getYahoo());;

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteContactInfor(int id) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM ContactInfor WHERE ID_ContactInfor = ?");
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
	
	public ArrayList<ContactInforDTO> findallContactInfor() {
		ArrayList<ContactInforDTO> listcti = new ArrayList<ContactInforDTO>();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Admin");
			while (rs.next()) {
				ContactInforDTO cti = new ContactInforDTO();
				cti.setID_ContactInfo(rs.getInt("ID_ContactInfor"));
				cti.setAddress(rs.getString("Address"));
				cti.setMobilePhone(rs.getString("MobiPhone"));
				cti.setTelePhone(rs.getString("TelePhone"));
				cti.setFAX(rs.getString("FAX"));
				cti.setEmail(rs.getString("Email"));
				cti.setSkype(rs.getString("Skype"));
				cti.setYahoo(rs.getString("Yahoo"));
				listcti.add(cti);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listcti;
	}
	
	public ContactInforDTO findidContactInforDTO(int id) {

		ContactInforDTO cti = new ContactInforDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM ContactInfor WHERE ID_ContactInfor = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				
				cti.setID_ContactInfo(rs.getInt("ID_ContactInfor"));
				cti.setAddress(rs.getString("Address"));
				cti.setMobilePhone(rs.getString("MobiPhone"));
				cti.setTelePhone(rs.getString("TelePhone"));
				cti.setFAX(rs.getString("FAX"));
				cti.setEmail(rs.getString("Email"));
				cti.setSkype(rs.getString("Skype"));
				cti.setYahoo(rs.getString("Yahoo"));
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cti;
	}


}

