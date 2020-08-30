package com.springbootsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootsecurity.entities.Employee;
import com.springbootsecurity.repositories.EmployeeRepository;

/**
 * @author Sonu Agrawal
 *
 */
@Service
public class EmployeesService {

	@Autowired
	EmployeeRepository employeeRepository;

	// getting all employees record by using the method findaAll() of CrudRepository
	public List<Employee> getAllEmployees() {
		List<Employee> employee = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
		return employee;
	}

	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}

	public void delete(int id) {
		employeeRepository.deleteById(id);

	}

	public void saveOrUpdate(Employee employee) {
		employeeRepository.save(employee);

	}

	public void update(Employee employee) {
		employeeRepository.save(employee);

	}

}
