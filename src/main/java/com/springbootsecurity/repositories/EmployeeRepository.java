package com.springbootsecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.springbootsecurity.entities.Employee;

/**
 * @author Sonu Agrawal
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer> {

	Optional<Employee> findByEmail(String email);

}
