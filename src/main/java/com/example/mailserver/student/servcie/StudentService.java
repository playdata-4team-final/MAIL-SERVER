package com.example.mailserver.student.servcie;

import com.example.mailserver.student.dto.StudentRequest;
import com.example.mailserver.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(StudentRequest request){
        repository.save(request.toEntity());
    }

}
