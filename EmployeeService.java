package com.Brahmam.demo.service;

import com.Brahmam.demo.model.EmployeesData;
import java.util.List;

public interface EmployeeService {
    EmployeesData addEmployee(EmployeesData employee);
    List<EmployeesData> addAllEmployees(List<EmployeesData> employees);
    List<EmployeesData> getAllEmployees();
    EmployeesData getEmployeeById(Long id);
    EmployeesData updateEmployee(Long id, EmployeesData employee);
    String deleteEmployee(Long id);
}

