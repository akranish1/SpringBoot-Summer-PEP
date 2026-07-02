package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create Employee
    @PostMapping("/create")
    public String createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // Display All Employees
    @GetMapping("/display")
    public List<Employee> displayEmployees() {
        return employeeService.getAllEmployees();
    }

    // Raise Salary
        @PutMapping("/raise/{name}")
        public String raiseSalary(
                @PathVariable String name,
                @RequestParam
                @Min(1)
                @Max(10)
                int percentage) {

            return employeeService.raiseSalary(name, percentage);
        
    }
}