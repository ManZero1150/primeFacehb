package th.co.aware.controllor;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class toPage implements Serializable{

	private static final long serialVersionUID = 1L;

	public String toShow() {
		return "show";
	}

	public String toAddNumber() {
		return "addNumber";
	}

}
