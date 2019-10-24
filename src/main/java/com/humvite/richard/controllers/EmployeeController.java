package com.humvite.richard.controllers;

import java.util.List;

import javax.validation.Valid;

import com.humvite.richard.dao.EmployeeDAO;
import com.humvite.richard.models.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employeeDAO.create(employee);

        return employee;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long empId) {

        Employee emp =  employeeDAO.findEmployee(empId);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(emp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee empDetails) {
        Employee emp = employeeDAO.update(empId, empDetails);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(emp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long empId) {
        Employee emp = employeeDAO.findEmployee(empId);

        if (emp == null) {
            return ResponseEntity.notFound().build();
        }

        employeeDAO.delete(empId);

        return ResponseEntity.ok().build();
    }
}
