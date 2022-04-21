package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Course;
import com.example.schoolmanagement.entities.Professor;
import com.example.schoolmanagement.entities.Student;
import com.example.schoolmanagement.repositories.CourseRepository;
import com.example.schoolmanagement.repositories.ProfessorRepository;
import com.example.schoolmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         StudentRepository studentRepository,
                         ProfessorRepository professorRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.professorRepository = professorRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course addNewCourse(Course course) {
        /*Optional<Course> courseOptional = courseRepository.findById(course.getId());
        if (courseOptional.isPresent()) {
            throw new IllegalStateException("course existed");
        }*/
        return courseRepository.save(course);
    }

    public Optional<Course> getById(Long courseId) {
        return courseRepository.findById(courseId);
    }

    public Course enrollStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException("course does not exists"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("student does not exists"));
        course.enrollStudent(student);
        return courseRepository.save(course);
    }

    public Course assignProfessorToCourse(Long courseId, Long professorId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalStateException("course does not exists"));
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(() -> new IllegalStateException("course does not exists"));
        course.setProfessor(professor);
        return courseRepository.save(course);
    }
}
