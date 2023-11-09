package com.example.mailserver.mail.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mail {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String senderEmail;
    private String receiverEmail;
    private String title;
    private String message;
    private boolean checkMail;
    private LocalDateTime sendTime;
    private Long majorId;

}
