package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public String saveEmployee(Employee employee) {

        // Age Validation
        if (employee.getAge() < 18 || employee.getAge() > 60) {
            return "Age should be between 18 and 60";
        }

        // Set Salary according to Designation
        switch (employee.getDesignation().toLowerCase()) {

        case "programmer":
            employee.setSalary(25000);
            break;

        case "manager":
            employee.setSalary(30000);
            break;

        case "tester":
            employee.setSalary(20000);
            break;

        default:
            return "Invalid Designation";
        }

        employeeRepository.save(employee);

        return "Employee Created Successfully";
    }

    // Display Employees
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();

    }

    // Raise Salary
    public String raiseSalary(String name, int percentage) {

        if (percentage < 1 || percentage > 10) {
            return "Percentage should be between 1 and 10";
        }

        Optional<Employee> optionalEmployee = employeeRepository.findByName(name);

        if (optionalEmployee.isEmpty()) {
            return "Employee Not Found";
        }

        Employee employee = optionalEmployee.get();

        double newSalary = employee.getSalary()
                + (employee.getSalary() * percentage / 100);

        employee.setSalary(newSalary);

        employeeRepository.save(employee);

        return "Salary Updated Successfully";
    }
}