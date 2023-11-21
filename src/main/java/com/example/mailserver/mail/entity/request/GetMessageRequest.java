package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetMessageRequest {

    private Long id;
    private String senderEmail;
    private String userId;
    private String message;

    public Mail toEntity(){
        return Mail
                .builder()
                .id(id)
                .senderEmail(senderEmail)
                .userId(userId)
                .message(message)
                .sendTime(LocalDateTime.now())
                .checkMail(false)
                .build();
    }
}
