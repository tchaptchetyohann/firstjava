package com.example.student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.particular.Student;

public interface Studendrepository extends JpaRepository<Student, Integer> {
    // This interface will automatically provide CRUD operations for the Student entity.
    // No additional methods are needed unless you want to define custom queries.

}
