package DAO;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import DTO.sinhvienDTO;

public class sinhvienDAO {
	private static void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static boolean add(sinhvienDTO sv) throws SQLException,
			ClassNotFoundException {
		ConnectionDB db = new ConnectionDB();
		db.openConnect();
		String sql = "insert into SinhVien(HoVaTen,Lop,GioiTinh,DiaChi,CMND,SDT) values(?,?,?,?,?,?)";
		Object[] parameters = { sv.getHoVaTen(), sv.getLop(), sv.getGioiTinh(),
				sv.getDiaChi(), sv.getCMND(), sv.getSDT() };
		int row = db.executeUpdate(sql, parameters);
		if (row > 0) {
			addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO,
					"User Registration Successful!!!", null));
			return true;
		}

		else {
			return false;
		}
	}
}
