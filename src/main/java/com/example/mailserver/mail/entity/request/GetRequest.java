package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetRequest {
    private String receiverEmail;
    private Long majorId;
    public Mail toEntity(){
        return Mail
                .builder()
                .receiverEmail(receiverEmail)
                .checkMail(true)
                .majorId(majorId)
                .build();
    }
}
