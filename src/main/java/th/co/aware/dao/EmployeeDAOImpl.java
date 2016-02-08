package th.co.aware.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import th.co.aware.model.Employee;


@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void register(Employee emp) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(emp);
		tx.commit();
		session.close();

	}
	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Employee> employeeList = session.createCriteria(Employee.class).list();
		session.close();
		return employeeList;
	}

}
