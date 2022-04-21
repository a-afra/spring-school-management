package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Student;
import com.example.schoolmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByStudentId(student.getStudentId());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("student ID existed");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new IllegalStateException("student does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> getById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    /*@Transactional
    public void updateStudent(Long studentId, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student does not exists"));

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email exists");
            }
            student.setEmail(email);
        }
    }*/
}
