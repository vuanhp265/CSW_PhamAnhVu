package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // 1. getEmployees: retrieve all employees in an array/list
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    // 2. addEmployees(Employee e): add a new employee record
    public Employee addEmployees(Employee e) {
        if (employeeRepository.existsById(e.getId())) {
            throw new IllegalArgumentException("Employee id " + e.getId() + " already exists");
        }
        return employeeRepository.save(e);
    }

    // 3. updateEmployee(Employee e): modify an existing employee record
    public Employee updateEmployee(Employee e) {
        if (!employeeRepository.existsById(e.getId())) {
            throw new IllegalArgumentException("Employee id " + e.getId() + " does not exist");
        }
        return employeeRepository.save(e);
    }
}
