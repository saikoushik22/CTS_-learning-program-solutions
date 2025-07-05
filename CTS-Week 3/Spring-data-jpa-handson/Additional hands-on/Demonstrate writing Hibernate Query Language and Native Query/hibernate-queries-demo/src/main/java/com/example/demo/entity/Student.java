package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String department;
    private double cgpa;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Loan> loans = new ArrayList<>();

    public Student() {}

    public Student(String name, String department, double cgpa) {
        this.name = name;
        this.department = department;
        this.cgpa = cgpa;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getCgpa() { return cgpa; }
    public List<Loan> getLoans() { return loans; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDepartment(String department) { this.department = department; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
    public void setLoans(List<Loan> loans) { this.loans = loans; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', dept='" + department + "', cgpa=" + cgpa + '}';
    }
}
