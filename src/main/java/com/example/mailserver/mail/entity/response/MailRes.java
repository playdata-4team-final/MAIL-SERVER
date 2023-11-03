package com.example.mailserver.mail.entity.response;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class MailRes {

    private Long id;
    private String senderId;
    private String receiverId;
    private String message;
    private LocalDateTime sendTime;
    private Boolean check;
    private String title;

    public MailRes(Mail mail) {
        this.id = mail.getId();
        this.title = mail.getTitle();
        this.senderId = mail.getSenderId();
        this.receiverId = mail.getReceiverId();
        this.message = mail.getMessage();
        this.sendTime = mail.getSendTime();
        this.check=mail.getCheck();
    }

    public MailRes(Long id, String senderId, String receiverId, String message, LocalDateTime sendTime, Boolean check, String title) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.sendTime = sendTime;
        this.check = check;
        this.title = title;
    }

    public Mail toEntity(){
        return  Mail
                .builder()
                .id(id)
                .senderId(senderId)
                .receiverId(receiverId)
                .message(message)
                .sendTime(sendTime)
                .check(check)
                .title(title)
                .build();
    }
}

