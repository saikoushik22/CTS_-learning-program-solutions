package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataRunner implements CommandLineRunner {

    private final StudentRepository repo;

    public DataRunner(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Student("Ravi", "CSE", 8.4));
        repo.save(new Student("Anu", "ECE", 9.0));
        repo.save(new Student("John", "EEE", 7.5));
        repo.findByCgpaGreaterThan(8.5).forEach(System.out::println);
        repo.findByDepartmentNative("CSE").forEach(System.out::println);
    }
}
