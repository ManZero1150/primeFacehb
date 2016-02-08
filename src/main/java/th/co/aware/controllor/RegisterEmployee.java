package th.co.aware.controllor;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import th.co.aware.bo.EmployeeBO;
import th.co.aware.model.Employee;

@ManagedBean
@SessionScoped
public class RegisterEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{EmployeeBOImpl}")
	private EmployeeBO employeeImpl;;

	private List<Employee> employees;
	private Employee employee = new Employee();

	@PostConstruct
	public void init() {
		this.employees = employeeImpl.findAll();
	}

	/**
	 * @return the employeeImpl
	 */
	public EmployeeBO getEmployeeImpl() {
		return employeeImpl;
	}

	/**
	 * @param employeeImpl the employeeImpl to set
	 */
	public void setEmployeeImpl(EmployeeBO employeeImpl) {
		this.employeeImpl = employeeImpl;
	}

	/**
	 * @return the employees
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		employee= (Employee) employeeImpl.findAll();
		this.employee = employee;
	}




	public String register() {
		employeeImpl.register(employee);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Employee"+this.employee.getEmpName()+"Is Success"));
		init();
		return "";
	}

	
}
