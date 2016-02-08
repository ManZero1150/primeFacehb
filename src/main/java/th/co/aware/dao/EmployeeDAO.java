package th.co.aware.dao;

import java.util.List;

import th.co.aware.model.Employee;

public interface EmployeeDAO {
	
	public void register(Employee emp);
	
	public List<Employee> findAll();

}
