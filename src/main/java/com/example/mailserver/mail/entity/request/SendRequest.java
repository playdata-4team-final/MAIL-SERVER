package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendRequest {

    private String userId;
    private String title;
    private Long majorId;
    private String senderEmail;
    private String message;

    public Mail toEntity(){
        return Mail
                .builder()
                .userId(userId)
                .senderEmail(senderEmail)
                .message(message)
                .majorId(majorId)
                .title(title)
                .sendTime(LocalDateTime.now())
                .majorId(majorId)
                .checkMail(false)
                .build();
    }

}
