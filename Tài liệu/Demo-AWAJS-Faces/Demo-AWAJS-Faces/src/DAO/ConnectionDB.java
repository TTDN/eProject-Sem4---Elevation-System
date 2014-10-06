package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionDB {
	public Connection con =null;
	public void openConnect() throws ClassNotFoundException, SQLException  {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 con = DriverManager.getConnection("jdbc:sqlserver://" + "BETOZUGI" + ":" + "1433" + ";databaseName=" + "SinhVien_AWAJS", "sa", "1234567");
		
	}
	
	public int executeUpdate(String sql, Object[] parameters) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		if(parameters != null) {
			for(int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
		}
		return ps.executeUpdate();
		
	}
	public ResultSet executeQuery(String sql, Object[] parameters) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		if(parameters != null) {
			for(int i = 0; i < parameters.length; i++) {
				ps.setObject(i + 1, parameters[i]);
			}
		}
		return ps.executeQuery();
	}
	
	public void closeConnect() throws SQLException {
		if(con != null) {
			con.close();
		}
	}
	
	
}
