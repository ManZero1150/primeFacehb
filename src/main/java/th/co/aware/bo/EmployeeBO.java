package th.co.aware.bo;

import java.util.List;

import th.co.aware.model.Employee;

public interface EmployeeBO {
	
	public void register(Employee emp);
	
	public List<Employee> findAll();

}
