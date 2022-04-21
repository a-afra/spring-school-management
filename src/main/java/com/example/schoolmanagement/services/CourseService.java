package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Course;
import com.example.schoolmanagement.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public void addNewCourse(Course course) {
        /*Optional<Course> courseOptional = courseRepository.findById(course.getId());
        if (courseOptional.isPresent()) {
            throw new IllegalStateException("course existed");
        }*/
        courseRepository.save(course);
    }
}
