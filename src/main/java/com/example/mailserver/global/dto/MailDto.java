package com.example.mailserver.global.dto;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MailDto {

    private Long id;
    private String senderId;
    private String receiverId;
    private String title;
    private String message;
    private Boolean check;
    private LocalDateTime sendTime;


    public MailDto(Mail mail) {
        this.id = mail.getId();
        this.senderId = mail.getSenderId();
        this.receiverId = mail.getReceiverId();
        this.title = mail.getTitle();
        this.message = mail.getMessage();
        this.check = mail.getCheck();
        this.sendTime = mail.getSendTime();
    }

    public MailDto(Long id, String senderId, String receiverId, String title, String message, Boolean check, LocalDateTime sendTime) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.title = title;
        this.message = message;
        this.check = check;
        this.sendTime = sendTime;
    }

   public Mail toEntity(){
        return Mail
                .builder()
                .id(id)
                .title(title)
                .senderId(senderId)
                .receiverId(receiverId)
                .message(message)
                .check(check)
                .sendTime(sendTime)
                .build();
   }
}
