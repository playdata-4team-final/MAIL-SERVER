package com.example.mailserver.mail.entity.response;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class MailRes {

    private Long id;
    private String senderEmail;
    private String receiverEmail;
    private String message;
    private Long majorId;
    private LocalDateTime sendTime;
    private boolean checkMail;
    private String title;

    public MailRes(Mail mail) {
        this.id = mail.getId();
        this.title = mail.getTitle();
        this.senderEmail = mail.getSenderEmail();
        this.receiverEmail = mail.getReceiverEmail();
        this.message = mail.getMessage();
        this.sendTime = mail.getSendTime();
        this.checkMail= false;
        this.majorId = mail.getMajorId();
    }

    public MailRes(Long id, String senderEmail, String receiverEmail, String message, LocalDateTime sendTime, String title ,Long majorId) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.message = message;
        this.sendTime = sendTime;
        this.checkMail = false;
        this.title = title;
        this.majorId =majorId;
    }

    public Mail toEntity(){
        return  Mail
                .builder()
                .id(id)
                .senderEmail(senderEmail)
                .receiverEmail(receiverEmail)
                .message(message)
                .sendTime(sendTime)
                .checkMail(false)
                .title(title)
                .build();
    }
}

