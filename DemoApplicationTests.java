package com.HPE.employee;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.HPE.employee.Entity.Employee;
import com.HPE.employee.controller.AccessEmployee;

@SpringBootTest
class DemoApplicationTests {
	
	@Mock

	private AccessEmployee employeeDao;
	
	//helper fundtion to get the number of current employee
	int getEmployeeCount(AccessEmployee accessEmployee) {
		return accessEmployee.getAllEmployees().getEmployeeList().size();
	}
	
	@Test
	//ensure that employee list is populated on initialization
	void createAccessEmployee() {
		AccessEmployee newAccessEmployee = new AccessEmployee();
		assert(getEmployeeCount(newAccessEmployee) !=0);
	}
	
	@Test
	//ensure that adding an employee increases the empolyee count by 1
	void addemployee() {
		AccessEmployee employeeDao = new AccessEmployee();
		int employeeCount = getEmployeeCount(employeeDao);
		Employee employee = new Employee();
		employeeDao.addEmployee(employee);
		assert(employeeCount+1 == getEmployeeCount(employeeDao));
	}
	
	@ExtendWith(MockitoExtension.class)
	@BeforeEach void setUp() {
		this.employeeDao = new AccessEmployee();
		Employee newEmployee = new Employee(3,"Daria","Jones", "dariajones@gmail.com");
		this.employeeDao.addEmployee(newEmployee);
	}
	
	@Test
	//check wheather added employee ID is found in ID field
	void employeeInList() {
		List<Employee> employees = this.employeeDao.getAllEmployees().getEmployeeList();
		for(int i=0; i<employees.size(); i++) {
			Employee employee = employees.get(i);
			if(employee.getId() == 3) {
				return;
			}
		}
		assert(false);
		
	}
	
	@Test
	//check whether added employee first name is found in firstname field
	void employeeFirstNameInList() {
		List<Employee> employees = this.employeeDao.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getFirstName() == "Daria")
			{
				return;
			}
		}
		assert(false);
	}
	@Test
	// Check whether added employee last name is found in last name field
	void employeeLastNameInList() {
		List<Employee> employees = this.employeeDao.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getLastName() == "Jones")
			{
				return;
			}
		}
		assert(false);
	}
	
	@Test
	// Check whether added employee email is found in email field
	void employeeEmailInList() {
		List<Employee> employees = this.employeeDao.getAllEmployees().getEmployeeList();
		for (int i=0; i<employees.size(); i++)
		{
			Employee employee = employees.get(i);
			if (employee.getEmail() == "dariajones@gmail.com")
			{
				return;
			}
		}
		assert(false);
	}
	

}
