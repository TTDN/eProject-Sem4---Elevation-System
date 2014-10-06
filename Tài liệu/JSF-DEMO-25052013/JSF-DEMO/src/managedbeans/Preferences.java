package managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="preferences")
public class Preferences {
	private String themes = "bluesky";

	public String getThemes() {
		return themes;
	}

	public void setThemes(String themes) {
		this.themes = themes;
	}
	
	public String switchTheme() {
//		this.themes = themes;
		return null;
	}
	
	
}
