package com.example.mailserver.mail.entity.request;

import com.example.mailserver.mail.entity.Mail;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DeleteRequest {

    private List<Long> mailIds;

    public List<Mail> toEntities() {
        return mailIds.stream()
                .map(id -> Mail.builder().id(id).build())
                .collect(Collectors.toList());
    }
}
