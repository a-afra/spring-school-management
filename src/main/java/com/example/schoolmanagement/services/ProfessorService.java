package com.example.schoolmanagement.services;

import com.example.schoolmanagement.entities.Professor;
import com.example.schoolmanagement.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getProfessors() {
        return professorRepository.findAll();
    }

    public Professor addNewProfessor(Professor professor) {
        return professorRepository.save(professor);
    }
}
