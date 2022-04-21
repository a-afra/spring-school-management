package com.example.schoolmanagement.controllers;

import com.example.schoolmanagement.entities.Professor;
import com.example.schoolmanagement.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/professor")
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getProfessors() {
        return professorService.getProfessors();
    }

    @PostMapping
    public void registerProfessor(@RequestBody Professor professor) {
        professorService.addNewProfessor(professor);
    }
}
