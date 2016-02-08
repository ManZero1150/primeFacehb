package th.co.aware.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.model.PhoneNumber;


@Component
public class PhoneNumberDAOImpl implements PhoneNumberDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addNumber(PhoneNumber phoneNumber) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(phoneNumber);
		tx.commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	public List<PhoneNumber> findAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<PhoneNumber> NumList = session.createCriteria(PhoneNumber.class).list();
		session.close();
		return NumList;
	}
	
	public void delete(PhoneNumber phoneNumber) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(phoneNumber);
		tx.commit();
		session.close();
	}

}
