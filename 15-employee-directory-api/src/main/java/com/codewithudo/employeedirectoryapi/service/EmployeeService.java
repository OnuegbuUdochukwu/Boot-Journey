package com.codewithudo.employeedirectoryapi.service;

import com.codewithudo.employeedirectoryapi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    // Add a new employee
    public boolean addEmployee(Employee employee) {
        employee.setId(nextId++);
        employees.add(employee);
        return true;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Get an employee by ID
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    // Update an employee by ID
    public boolean updateEmployee(int id, Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(updatedEmployee.getName());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setEmail(updatedEmployee.getEmail());
                employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    // Delete an employee by ID
    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId().equals(id));
    }
}
