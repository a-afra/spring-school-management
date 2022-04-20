package com.example.schoolmanagement.repositories;

import com.example.schoolmanagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.studentId = ?1")
    Optional<Student> findByStudentId(Long studentId);
}
