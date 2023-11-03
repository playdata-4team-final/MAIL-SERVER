package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SendGroupRequest {

    private String senderId;
    private String receiverId;
    private String message;
    private Long majorId;

    public Mail toEntity(){
        return Mail
                .builder()
                .senderId(senderId)
                .receiverId(receiverId)
                .message(message)
                .sendTime(LocalDateTime.now())
                .check(false)
                .majorId(majorId)
                .build();
    }

}
