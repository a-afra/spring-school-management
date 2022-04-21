package com.example.schoolmanagement.controllers;

import com.example.schoolmanagement.entities.Course;
import com.example.schoolmanagement.entities.Student;
import com.example.schoolmanagement.services.CourseService;
import com.example.schoolmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PostMapping
    public Course registerNewCourse(@RequestBody Course course) {
        return courseService.addNewCourse(course);
    }

    @PutMapping(path = "/{courseId}/student/{studentId}")
    public Course enrollStudentToCourse(
            @PathVariable("courseId") Long courseId,
            @PathVariable("studentId") Long studentId) {
        return courseService.enrollStudentToCourse(courseId, studentId);
    }
}
