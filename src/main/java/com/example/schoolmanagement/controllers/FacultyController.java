package com.example.schoolmanagement.controllers;

import com.example.schoolmanagement.entities.Faculty;
import com.example.schoolmanagement.services.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @PostMapping
    public Faculty registerNewFaculty(@RequestBody Faculty faculty) {
        return facultyService.addNewFaculty(faculty);
    }
}
