package com.example.demo.repository;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCase(String keyword);
    List<Employee> findAllByOrderByNameAsc();
    List<Employee> findByNameStartingWithIgnoreCase(String prefix);
    List<Employee> findByJoinDateBetween(LocalDate start, LocalDate end);
    List<Employee> findBySalaryGreaterThan(double amount);
    List<Employee> findBySalaryLessThan(double amount);
    List<Employee> findTop3ByOrderBySalaryDesc();
}
