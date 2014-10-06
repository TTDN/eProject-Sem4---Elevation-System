package managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="hello")
public class HelloBean {
	final String world = "Hello World!";

    public String getWorld() {
        return world;
    }
}
