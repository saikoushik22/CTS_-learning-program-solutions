package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.cgpa > :cgpa")
    List<Student> findByCgpaGreaterThan(@Param("cgpa") double cgpa);

    @Query(value = "select * from student where department = ?1", nativeQuery = true)
    List<Student> findByDepartmentNative(String dept);
}
