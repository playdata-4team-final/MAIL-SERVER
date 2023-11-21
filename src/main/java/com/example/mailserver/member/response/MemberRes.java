package com.example.mailserver.mail.entity.response;

import com.example.mailserver.mail.entity.MemberRole;
import com.example.mailserver.mail.entity.MemberStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class MemberRes {

    private String id;
    private String name;
    private String userId;
    private String password;
    private String email;
    private String phNumber;
    private MemberStatus status;
    private MemberRole role;
}
