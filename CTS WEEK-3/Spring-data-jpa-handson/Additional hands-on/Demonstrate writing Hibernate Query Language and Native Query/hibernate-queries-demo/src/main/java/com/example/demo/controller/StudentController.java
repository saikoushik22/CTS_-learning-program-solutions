package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    @GetMapping("/highcgpa/{cgpa}")
    public List<Student> highCgpa(@PathVariable double cgpa) {
        return repo.findByCgpaGreaterThan(cgpa);
    }

    @GetMapping("/dept/{dept}")
    public List<Student> byDept(@PathVariable String dept) {
        return repo.findByDepartmentNative(dept);
    }
}
