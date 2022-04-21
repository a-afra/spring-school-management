package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Course;
import com.example.schoolmanagement.entities.Student;
import com.example.schoolmanagement.repositories.CourseRepository;
import com.example.schoolmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
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
}
