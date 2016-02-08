package th.co.aware.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the main_packages database table.
 * 
 */
@Entity
@Table(name="main_packages")
@NamedQuery(name="MainPackage.findAll", query="SELECT m FROM MainPackage m")
public class MainPackage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="main_package_id")
	private int mainPackageId;

	private String code;

	@Lob
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	private String name;

	private double price;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;

	//bi-directional many-to-one association to UserPhoneNumber
	@OneToMany(mappedBy="mainPackage")
	private List<UserPhoneNumber> userPhoneNumbers;

	public MainPackage() {
	}

	public int getMainPackageId() {
		return this.mainPackageId;
	}

	public void setMainPackageId(int mainPackageId) {
		this.mainPackageId = mainPackageId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<UserPhoneNumber> getUserPhoneNumbers() {
		return this.userPhoneNumbers;
	}

	public void setUserPhoneNumbers(List<UserPhoneNumber> userPhoneNumbers) {
		this.userPhoneNumbers = userPhoneNumbers;
	}

	public UserPhoneNumber addUserPhoneNumber(UserPhoneNumber userPhoneNumber) {
		getUserPhoneNumbers().add(userPhoneNumber);
		userPhoneNumber.setMainPackage(this);

		return userPhoneNumber;
	}

	public UserPhoneNumber removeUserPhoneNumber(UserPhoneNumber userPhoneNumber) {
		getUserPhoneNumbers().remove(userPhoneNumber);
		userPhoneNumber.setMainPackage(null);

		return userPhoneNumber;
	}

}