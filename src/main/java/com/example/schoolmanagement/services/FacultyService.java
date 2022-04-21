package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Faculty;
import com.example.schoolmanagement.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty addNewFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
