package th.co.aware.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.co.aware.dao.PhoneNumberDAO;
import th.co.aware.model.PhoneNumber;


@Service("PhoneNumberBOImpl")
@Transactional(readOnly = true)
public class PhoneNumberBOImpl implements PhoneNumberBO {

	@Autowired
	private PhoneNumberDAO phoneNumberDAO;

	@Transactional(readOnly = false)
	public void addNumber(PhoneNumber phoneNumber) {
		// TODO Auto-generated method stub
		phoneNumberDAO.addNumber(phoneNumber);

	}

	@Transactional
	public List<PhoneNumber> findAll() {
		// TODO Auto-generated method stub
		return phoneNumberDAO.findAll();
	}
	
	public void delete(PhoneNumber phoneNumber) throws Exception {
		if(phoneNumber == null || phoneNumber.getNo() == null){
			throw  new Exception("Not value No.");
		}else{
			phoneNumberDAO.delete(phoneNumber);
		}
		
	}

}
