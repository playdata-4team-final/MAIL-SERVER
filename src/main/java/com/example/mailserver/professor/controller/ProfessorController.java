package com.example.mailserver.professor.controller;


import com.example.mailserver.professor.dto.ProfessorRequest;
import com.example.mailserver.professor.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lms")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping("/professor")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProfessor(@RequestBody ProfessorRequest request){
        professorService.saveProfessor(request);
    }
}
