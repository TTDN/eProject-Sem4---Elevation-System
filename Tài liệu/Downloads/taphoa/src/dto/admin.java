package dto;

import java.sql.*;

public class admin {
	int iduser;
	String username;
	String password;
	int phone;
	Date ngaysinh;
	String email;
	String diachi;

	public admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public admin(int iduser, String username, String password, int phone,
			Date ngaysinh, String email, String diachi) {
		super();
		this.iduser = iduser;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.ngaysinh = ngaysinh;
		this.email = email;
		this.diachi = diachi;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

}
