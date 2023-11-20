package com.example.mailserver.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @Column(columnDefinition = "VARCHAR(36)", unique = true)
    private String id;
    private String studentName;
    //학년
    private Integer year;
    private Integer studentNumber;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phNumber;

    private String majorName;
}

