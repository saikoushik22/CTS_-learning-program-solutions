package com.example.demo.data;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {

    private final EmployeeRepository repo;

    public DBSeeder(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.saveAll(List.of(
                new Employee("Alice",   60000, LocalDate.of(2023, 1, 1)),
                new Employee("Bob",     45000, LocalDate.of(2024, 1, 1)),
                new Employee("Charlie", 70000, LocalDate.of(2022, 5, 10)),
                new Employee("David",   40000, LocalDate.of(2024, 3, 15))
        ));

        System.out.println("\n=== Contains 'a' ===");
        repo.findByNameContainingIgnoreCase("a").forEach(System.out::println);

        System.out.println("\n=== Sorted by Name ===");
        repo.findAllByOrderByNameAsc().forEach(System.out::println);

        System.out.println("\n=== Starts with 'A' ===");
        repo.findByNameStartingWithIgnoreCase("A").forEach(System.out::println);

        System.out.println("\n=== Joined between 2023-01-01 and 2025-01-01 ===");
        repo.findByJoinDateBetween(LocalDate.of(2023,1,1), LocalDate.of(2025,1,1))
            .forEach(System.out::println);

        System.out.println("\n=== Salary > 50000 ===");
        repo.findBySalaryGreaterThan(50000).forEach(System.out::println);

        System.out.println("\n=== Salary < 50000 ===");
        repo.findBySalaryLessThan(50000).forEach(System.out::println);

        System.out.println("\n=== Top 3 Salaries ===");
        repo.findTop3ByOrderBySalaryDesc().forEach(System.out::println);
    }
}
