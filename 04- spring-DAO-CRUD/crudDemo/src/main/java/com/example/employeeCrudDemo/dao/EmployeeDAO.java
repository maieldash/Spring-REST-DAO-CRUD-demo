package com.example.employeeCrudDemo.dao;

import com.example.employeeCrudDemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void delete(int id);

}
