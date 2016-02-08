package th.co.aware.controllor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import th.co.aware.bo.PhoneNumberBO;
import th.co.aware.model.PhoneNumber;

@ManagedBean
@SessionScoped
public class addNumber implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{PhoneNumberBOImpl}")
	private PhoneNumberBO phoneNumberImpl;;

	private List<PhoneNumber> phoneNumbers;
	private PhoneNumber phoneNumber = new PhoneNumber();

	@PostConstruct
	public void init() {
		this.phoneNumbers = phoneNumberImpl.findAll();
	}

	public PhoneNumberBO getPhoneNumberImpl() {
		return phoneNumberImpl;
	}

	public void setPhoneNumberImpl(PhoneNumberBO phoneNumberImpl) {
		this.phoneNumberImpl = phoneNumberImpl;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	/**
	 * @return the phoneNumber
	 */
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumber = (PhoneNumber) phoneNumberImpl.findAll();
		this.phoneNumber = phoneNumber;
	}

	public String addNumber() {		
		
		phoneNumberImpl.addNumber(phoneNumber);

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("No." + this.phoneNumber.getNo() + "Is Add Successful"));
		init();

		return "";
	}

	public String delete() {
		try {
			phoneNumberImpl.delete(phoneNumber);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("The Number " + e.getMessage()));
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Number " + this.phoneNumber.getNo() + " Is Deleted Successful"));
		init();
		return "";
	}
	
	

}
