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
    private String receiverEmail;
    private String title;
    private String message;
    private boolean checkMail;
    private LocalDateTime sendTime;


    public MailDto(Mail mail) {
        this.id = mail.getId();
        this.senderEmail = mail.getSenderEmail();
        this.receiverEmail = mail.getReceiverEmail();
        this.title = mail.getTitle();
        this.message = mail.getMessage();
        this.checkMail = false;
        this.sendTime = mail.getSendTime();
    }

    public MailDto(Long id, String senderEmail, String receiverEmail, String title, String message, boolean checkMail, LocalDateTime sendTime) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
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
                .receiverEmail(receiverEmail)
                .message(message)
                .checkMail(false)
                .sendTime(sendTime)
                .build();
   }
}
