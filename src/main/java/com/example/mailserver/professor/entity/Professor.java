package com.example.mailserver.professor.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @Column(columnDefinition = "VARCHAR(36)", unique = true)
    private String id;

    private String professorName;
    @Column(unique = true)
    private String phNumber;
    @Column(unique = true)
    private String email;

    private List<String> majorName;



}