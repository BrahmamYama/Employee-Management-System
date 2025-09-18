package com.Brahmam.demo.service;

import com.Brahmam.demo.model.EmployeesData;
import com.Brahmam.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeesData addEmployee(EmployeesData employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<EmployeesData> addAllEmployees(List<EmployeesData> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public List<EmployeesData> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeesData getEmployeeById(Long id) {
        Optional<EmployeesData> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public EmployeesData updateEmployee(Long id, EmployeesData updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
            employee.setDepartment(updatedEmployee.getDepartment());
            employee.setDesignation(updatedEmployee.getDesignation());
            employee.setSalary(updatedEmployee.getSalary());
            employee.setDateOfJoining(updatedEmployee.getDateOfJoining());
            employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
            employee.setGender(updatedEmployee.getGender());
            employee.setStatus(updatedEmployee.getStatus());
            return employeeRepository.save(employee);
        }).orElse(null);
    }

    @Override
    public String deleteEmployee(Long id) {
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully!";
        }
        return "Employee not found!";
    }
}

