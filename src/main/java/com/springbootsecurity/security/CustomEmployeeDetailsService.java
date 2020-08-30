package com.springbootsecurity.security;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootsecurity.entities.Employee;
import com.springbootsecurity.repositories.EmployeeRepository;

/**
 * @author Sonu Agrawal
 *
 */
@Service
@Transactional
public class CustomEmployeeDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByEmail(userName)
				.orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
		return new org.springframework.security.core.userdetails.User(employee.getEmail(), employee.getPassword(),
				getAuthorities(employee));
	}

	private static Collection<? extends GrantedAuthority> getAuthorities(Employee employee) {
		String[] employeeRoles = employee.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(employeeRoles);
		return authorities;
	}

}
