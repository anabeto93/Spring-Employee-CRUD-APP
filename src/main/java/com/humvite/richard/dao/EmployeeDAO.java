package com.humvite.richard.dao;

import java.util.List;

import com.humvite.richard.error.ResourceNotFoundException;
import com.humvite.richard.models.Employee;
import com.humvite.richard.repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;

    /*Create an Employee*/
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    /*Read/Search for Employee*/
    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee id '" + id + "' does no exist")
        );
    }

    /*List Employees*/
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /*Update Employee*/
    public Employee update(Long empId, Employee updatedEmployeeDetails) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(
                () -> new ResourceNotFoundException("Employee id '" + empId + "' does no exist")
        );

        employee.setName(updatedEmployeeDetails.getName());
        employee.setDesignation(updatedEmployeeDetails.getDesignation());
        employee.setExpertise(updatedEmployeeDetails.getExpertise());

        return employeeRepository.save(employee);
    }

    /*Delete Employee*/
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee id '" + id + "' does no exist")
        );

        employeeRepository.deleteById(id);
    }
}
