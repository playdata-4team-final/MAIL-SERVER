package com.example.mailserver.student.dto;


import com.example.mailserver.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequest {
    private String id;
    private String studentName;
    private Integer year;
    private int studentNumber;
    private String email;
    private String phNumber;

    public Student toEntity(){
        return Student.builder()
                .id(id)
                .studentName(studentName)
                .year(year)
                .studentNumber(studentNumber)
                .email(email)
                .phNumber(phNumber)
                .build();
    }
}
