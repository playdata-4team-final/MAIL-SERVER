package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendGroupRequest {

    private String senderEmail;
    private String title;
    private String message;
    private Long majorId;

    public Mail toEntity(){
        return Mail
                .builder()
                .senderEmail(senderEmail)
                .title(title)
                .message(message)
                .sendTime(LocalDateTime.now())
                .checkMail(false)
                .majorId(majorId)
                .build();
    }

}
