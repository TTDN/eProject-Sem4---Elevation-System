package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ProjectDTO;

public class ProjectDAO{
	
	public boolean InsertProject(ProjectDTO p){
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Project (Name,Contents) VALUES(?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getContents());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean UpdateProject(ProjectDTO p){
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;ader=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Project SET Name=?,Contents=? WHERE ID_Project=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getContents());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean DeleteProject(int id){
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM Project WHERE ID_Project = ?");
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
	
	public List<ProjectDTO> FindAllProject(){
		
		ArrayList<ProjectDTO> listproject = new ArrayList<ProjectDTO>();
		
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Elevation System;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Project");
			while (rs.next()) {
				
				ProjectDTO p = new ProjectDTO();
				p.setName("Name");
				p.setContents("Contents");
				listproject.add(p);
			}
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listproject;
	}
}