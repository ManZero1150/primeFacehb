package th.co.aware.dao;

import java.util.List;

import th.co.aware.model.PhoneNumber;

public interface PhoneNumberDAO {
	
	public void addNumber(PhoneNumber phoneNumber);
	
	public void delete(PhoneNumber phoneNumber);
	
	public List<PhoneNumber> findAll();

}
