package com.Brahmam.demo.repo;

import com.Brahmam.demo.model.EmployeesData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeesData, Long> {
}
