# EmployeeManagementSystem
Employee Management System Using Spring Boot + JPA + Thymeleaf + Spring MVC + Role Based Spring Security


Added the Spring Security Starter (spring-boot-starter-security) to a Spring Boot application for:
- Enable HTTP basic security
- Register the AuthenticationManager bean with an in-memory store and a single user
- Enable common low-level features such as XSS, CSRF, caching, etc.

Spring Security uses the UserDetailsService interface, which contains the loadUserByUsername(String username) method to look up UserDetails for a given username. 
The UserDetails interface represents an authenticated user object and Spring Security provides an out-of-the box implementation of org.springframework.security.core.userdetails.User. Now we implement a UserDetailsService to get UserDetails from database.


Spring Boot implemented the default Spring Security autoconfiguration in SecurityAutoConfiguration. 
To switch the default web application security configuration and provide our own customized security configuration, created a configuration class that extends WebSecurityConfigurerAdapter to customize the default Spring Security configuration.

configures CustomEmployeeDetailsService and BCryptPasswordEncoder to be used by AuthenticationManager instead of the default in-memory database with a single-user with a plaintext password.Used Thymeleaf view templates for rendering views. The thymeleaf-extrasspringsecurity4 module provides Thymeleaf Spring Security dialect attributes
