package th.co.aware.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_card_number")
	private int idCardNumber;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	@Lob
	private String description;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="register_date")
	private Date registerDate;

	//bi-directional many-to-one association to UserPhoneNumber
	@OneToMany(mappedBy="customer")
	private List<UserPhoneNumber> userPhoneNumbers;

	public Customer() {
	}

	public int getIdCardNumber() {
		return this.idCardNumber;
	}

	public void setIdCardNumber(int idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getRegisterDate() {
		return this.registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public List<UserPhoneNumber> getUserPhoneNumbers() {
		return this.userPhoneNumbers;
	}

	public void setUserPhoneNumbers(List<UserPhoneNumber> userPhoneNumbers) {
		this.userPhoneNumbers = userPhoneNumbers;
	}

	public UserPhoneNumber addUserPhoneNumber(UserPhoneNumber userPhoneNumber) {
		getUserPhoneNumbers().add(userPhoneNumber);
		userPhoneNumber.setCustomer(this);

		return userPhoneNumber;
	}

	public UserPhoneNumber removeUserPhoneNumber(UserPhoneNumber userPhoneNumber) {
		getUserPhoneNumbers().remove(userPhoneNumber);
		userPhoneNumber.setCustomer(null);

		return userPhoneNumber;
	}

}