package com.example.mailserver.member.response;

import com.example.mailserver.member.MemberRole;
import com.example.mailserver.member.MemberStatus;
import lombok.Getter;
import lombok.Setter;

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
