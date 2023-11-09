package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendRequest {

    private String senderEmail;
    private String title;
    private Long majorId;
    private String receiverEmail;
    private String message;

    public Mail toEntity(){
        return Mail
                .builder()
                .senderEmail(senderEmail)
                .receiverEmail(receiverEmail)
                .message(message)
                .majorId(majorId)
                .title(title)
                .sendTime(LocalDateTime.now())
                .majorId(majorId)
                .checkMail(false)
                .build();
    }

}
