package bo;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.admimDAO;
import dto.admin;

@ManagedBean(name = "admin")
public class admimBO {
	private boolean editMode;

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	private admin ad = new admin();

	private List<admin> listadAdmins;

	public List<admin> getListadAdmins() {
		return listadAdmins;
	}

	public void setListadAdmins(List<admin> listadAdmins) {
		this.listadAdmins = listadAdmins;
	}

	public admin getAd() {
		return ad;
	}

	public void setAd(admin ad) {
		this.ad = ad;
	}

	public admimBO() {
		admimDAO adao = new admimDAO();
		listadAdmins = adao.findalladmin();
	}

	public String insertAD() {
		admimDAO adao = new admimDAO();
		adao.insertadmin(ad);
		return "thanhcong";
	}

	public String deleteAD(admin add) {
		admimDAO adao = new admimDAO();
		adao.deleteadmin(add.getIduser());
		return "thanhcong";
	}

	public String save(admin add) {
		System.out.println("AAAAAAAAAAAAAAAAAAAAA");
		admimDAO adao = new admimDAO();
		adao.updateadmin(add);
		editMode = false;
		return null;
	}

	public String switchToEditMode(admin add) {
		editMode = true;
		ad = add;
		return null;
	}

	public boolean isEditingAdmin(admin add) {
		if (editMode && ad != null && (ad.getIduser() == add.getIduser())) {
			return true;
		}
		return false;
	}
}
