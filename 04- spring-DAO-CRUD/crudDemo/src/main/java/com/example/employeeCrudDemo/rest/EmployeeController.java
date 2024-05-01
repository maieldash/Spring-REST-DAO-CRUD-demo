package com.example.employeeCrudDemo.rest;

import com.example.employeeCrudDemo.dao.EmployeeDAOJpaImpl;
import com.example.employeeCrudDemo.entity.Employee;
import com.example.employeeCrudDemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {

        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById (@PathVariable int employeeId) {
        Employee   employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("the id of the employee is not found - " + employeeId);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployees (@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployees (@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById (@PathVariable int employeeId) {
        Employee   employee = employeeService.findById(employeeId);
        if(employee == null) {
            throw new RuntimeException("the id of the employee is not found - " + employeeId);
        }
        employeeService.delete(employeeId);
        return "Employee with id " + employeeId + " deleted successfully";
    }




}
