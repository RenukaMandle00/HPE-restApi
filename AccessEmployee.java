package com.HPE.employee.controller;

// Importing the employees class to 
// use the defined properties 
// in this class 
import org.springframework.stereotype.Repository;
import com.HPE.employee.controller.EmployeeStorage;
import com.HPE.employee.Entity.Employee; 
@Repository

// Class to create a list 
// of employees 

public class AccessEmployee {
	
		private static EmployeeStorage list 
			= new EmployeeStorage(); 

		// This static block is executed 
		// before executing the main 
		// block 
		static
		{ 

			// Creating a few employees 
			// and adding them to the list 
			list.getEmployeeList().add( 
				new Employee( 
					1, 
					"Prem", 
					"Tiwari", 
					"chapradreams@gmail.com")); 

			list.getEmployeeList().add( 
				new Employee( 
					2, "Vikash", 
					"Kumar", 
					"abc@gmail.com")); 

			list.getEmployeeList().add( 
				new Employee( 
					3, "Ritesh", 
					"Ojha", 
					"asdjf@gmail.com")); 

			  
		} 

		// Method to return the list 
		public EmployeeStorage getAllEmployees() 
		{ 

			return list; 
		} 

		  
			// Method to add an employee 
			// to the employees list 
			public void
			addEmployee(Employee employee) 
		{ 
			list.getEmployeeList() 
				.add(employee); 
			  
		} 
	} 



