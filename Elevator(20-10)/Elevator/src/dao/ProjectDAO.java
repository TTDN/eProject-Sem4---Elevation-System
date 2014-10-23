package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import dto.ProductDTO;
import dto.ProjectDTO;

public class ProjectDAO {

	public static boolean InsertProject(ProjectDTO p) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Project (Name,Contents,Images,Description) VALUES(?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getContents());
			ps.setString(3, p.getImages());
			ps.setString(4, p.getDescription());

			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean UpdateProject(ProjectDTO p) {
		System.out.println(p);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			PreparedStatement ps = conn
					.prepareStatement("UPDATE Project SET Name=?,Contents=?,Images=?,Description=?  WHERE ID_Project=?");
			ps.setString(1, p.getName());
			ps.setString(2, p.getContents());
			ps.setString(3, p.getImages());
			ps.setString(4, p.getDescription());
			ps.setInt(5, p.getID_Project());
			int kq = ps.executeUpdate();
			if (kq == 1) {
				return true;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean DeleteProject(int id) {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
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

	public List<ProjectDTO> FindAllProject() {

		// ArrayList<ProjectDTO> listproject = new ArrayList<ProjectDTO>();
		//
		// try {
		// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// Connection conn = (Connection) DriverManager
		// .getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
		// Statement stmt = (Statement) conn.createStatement();
		// ResultSet rs = stmt.executeQuery("SELECT * FROM Project");
		// while (rs.next()) {
		//
		// ProjectDTO p = new ProjectDTO();
		// p.setName("Name");
		// p.setContents("Contents");
		// p.setImages("Images");
		// p.setDescription("Description");
		// listproject.add(p);
		// }
		// } catch (SQLException | ClassNotFoundException e) {
		// e.printStackTrace();
		// }
		//
		// return listproject;

		ArrayList<ProjectDTO> listproject = new ArrayList<ProjectDTO>();

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Project");
			while (rs.next()) {

				ProjectDTO p = new ProjectDTO();
				p.setID_Project(rs.getInt("ID_Project"));
				p.setName(rs.getString("Name"));
				p.setImages(rs.getString("Images"));
				p.setDescription(rs.getString("Description"));

				p.setContents(rs.getString("Contents"));
				listproject.add(p);

			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return listproject;
	}

	public static ProjectDTO FindProjectByID(int id) {
		ProjectDTO pr = new ProjectDTO();
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = (Connection) DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ElevationSystem;user=sa;password=1234567;");
			// Statement stmt = (Statement) conn.createStatement();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM Project WHERE ID_Project = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				pr.setID_Project(rs.getInt("ID_Project"));
				pr.setName(rs.getString("Name"));
				pr.setImages(rs.getString("Images"));
				pr.setDescription(rs.getString("Description"));

				pr.setContents(rs.getString("Contents"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return pr;
	}
}