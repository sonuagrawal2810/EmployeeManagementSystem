package com.springbootsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootsecurity.service.EmployeesService;
import com.springbootsecurity.entities.Employee;

/**
 * @author Sonu Agrawal
 *
 */
@RestController
public class EmployeeController {

	// autowire the EmployeesService class
	@Autowired
	EmployeesService employeesService;

	// creating a get mapping that retrieves all the employees detail from the
	// database
	@GetMapping("/employee")
	private List<Employee> getAllEmployees() {
		return employeesService.getAllEmployees();
	}

	// creating a get mapping that retrieves the detail of a specific employee
	@GetMapping("/employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		return employeesService.getEmployeeById(id);
	}

	// creating a delete mapping that deletes a specified employee
	@DeleteMapping("/employee/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		employeesService.delete(id);
	}

	// creating post mapping that post the employee detail in the database
	@PostMapping("/employee")
	private int saveEmployee(@RequestBody Employee employee) {
		employeesService.saveOrUpdate(employee);
		return employee.getEmployeeid();
	}

	// creating put mapping that updates the employee detail
	@PutMapping("/employee")
	private Employee update(@RequestBody Employee employee) {
		employeesService.update(employee);
		return employee;
	}
}