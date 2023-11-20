package com.example.mailserver.mail.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String email;

    private String majorName;

    private String phNumber;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MemberStatus status;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private MemberRole role;

}
