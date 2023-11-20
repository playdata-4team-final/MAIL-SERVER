package com.example.mailserver.professor.service;


import com.example.mailserver.professor.dto.ProfessorDto;
import com.example.mailserver.professor.dto.ProfessorRequest;
import com.example.mailserver.professor.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;


    public void saveProfessor(ProfessorRequest request) {
        professorRepository.save(request.toEntity());
    }
}
