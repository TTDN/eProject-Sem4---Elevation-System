package util;

import java.util.Map;

import javax.faces.context.FacesContext;

public class HttpUtil {

	public static void putToSession(String name, Object value) {

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put(name, value);
	}
	
	public static Object getFromSession(String name) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		return sessionMap.get(name);
	}
}