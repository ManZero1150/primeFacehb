package th.co.aware.bo;

import java.util.List;

import th.co.aware.model.PhoneNumber;

public interface PhoneNumberBO {
	
	public void addNumber(PhoneNumber phoneNumber);
	
	public void delete(PhoneNumber phoneNumber) throws Exception;
	
	public List<PhoneNumber> findAll();

}
