package com.csi.service;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepoImpl;

    public Employee signUp(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public Optional<Employee> findById(int empId) {
        return employeeRepoImpl.findById(empId);
    }

    public List<Employee> findByEmpName(String empName) {
        return employeeRepoImpl.findByEmpName(empName);
    }

    public List<Employee> findAll() {
        return employeeRepoImpl.findAll();
    }

    public Employee updateData(Employee employee) {
        return employeeRepoImpl.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepoImpl.deleteById(empId);
    }

    public void deleteAll() {
        employeeRepoImpl.deleteAll();
    }
}
