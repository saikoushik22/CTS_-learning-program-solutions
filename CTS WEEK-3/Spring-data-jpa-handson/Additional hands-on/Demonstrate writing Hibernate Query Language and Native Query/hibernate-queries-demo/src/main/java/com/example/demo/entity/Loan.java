package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Loan() {}

    public Loan(double amount, Student student) {
        this.amount = amount;
        this.student = student;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public Student getStudent() { return student; }

    public void setId(Long id) { this.id = id; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setStudent(Student student) { this.student = student; }
}
