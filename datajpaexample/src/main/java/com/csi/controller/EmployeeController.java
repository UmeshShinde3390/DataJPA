package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee) {
        return new ResponseEntity<>(employeeServiceImpl.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/findbyid")
    public ResponseEntity<Optional<Employee>> findById(@RequestParam int empId) {
        return ResponseEntity.ok(employeeServiceImpl.findById(empId));
    }

    @GetMapping("/findbyname")
    public ResponseEntity<List<Employee>> findByName(@RequestParam String empName) {
        return ResponseEntity.ok(employeeServiceImpl.findByEmpName(empName));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }

    @PutMapping("/updatedata")
    public ResponseEntity<Employee> updateData(@RequestParam int empId, @Valid @RequestBody Employee employee) {
        Employee employee1 = employeeServiceImpl.findById(empId).orElseThrow(() -> new RecordNotFoundException("Id does not exist"));

        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpName(employee.getEmpName());

        return new ResponseEntity<>(employeeServiceImpl.updateData(employee1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteById(@RequestParam int empId) {
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data deleted successfully");
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteall() {
        employeeServiceImpl.deleteAll();
        return ResponseEntity.ok("All Data deleted successfully");
    }

}
