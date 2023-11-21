package com.example.mailserver.global.dto;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MailDto {

    private Long id;
    private String senderEmail;
    private String userId;
    private String title;
    private String message;
    private boolean checkMail;
    private LocalDateTime sendTime;


    public MailDto(Mail mail) {
        this.id = mail.getId();
        this.senderEmail = mail.getSenderEmail();
        this.userId = mail.getUserId();
        this.title = mail.getTitle();
        this.message = mail.getMessage();
        this.checkMail = false;
        this.sendTime = mail.getSendTime();
    }

    public MailDto(Long id, String userId, String receiverEmail, String title, String message, boolean checkMail, LocalDateTime sendTime) {
        this.id = id;
        this.senderEmail = userId;
        this.userId = receiverEmail;
        this.title = title;
        this.message = message;
        this.checkMail = checkMail;
        this.sendTime = sendTime;
    }

   public Mail toEntity(){
        return Mail
                .builder()
                .id(id)
                .title(title)
                .senderEmail(senderEmail)
                .userId(userId)
                .message(message)
                .checkMail(false)
                .sendTime(sendTime)
                .build();
   }
}
