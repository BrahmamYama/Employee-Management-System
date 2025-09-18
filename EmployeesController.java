package com.Brahmam.demo.controller;

import com.Brahmam.demo.model.EmployeesData;
import com.Brahmam.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<EmployeesData> addEmployee(@RequestBody EmployeesData employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<EmployeesData>> addAllEmployees(@RequestBody List<EmployeesData> employees) {
        return new ResponseEntity<>(employeeService.addAllEmployees(employees), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeesData>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeesData> getEmployeeById(@PathVariable Long id) {
        EmployeesData employee = employeeService.getEmployeeById(id);
        if(employee != null)
            return new ResponseEntity<>(employee, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeesData> updateEmployee(@PathVariable Long id, @RequestBody EmployeesData updatedEmployee) {
        EmployeesData employee = employeeService.updateEmployee(id, updatedEmployee);
        if(employee != null)
            return new ResponseEntity<>(employee, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        String result = employeeService.deleteEmployee(id);
        if(result.equals("Employee deleted successfully!"))
            return new ResponseEntity<>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
    }
}

