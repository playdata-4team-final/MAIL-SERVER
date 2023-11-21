package com.example.mailserver.member.request;


import com.example.mailserver.member.MemberEntity;
import com.example.mailserver.member.MemberRole;
import com.example.mailserver.member.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberRequest {
    private String id;
    private String name;
    private Integer year;
    private String email;
    private String phNumber;
    private MemberRole role;
    private MemberStatus status;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .userId(id)
                .name(name)
                .email(email)
                .phNumber(phNumber)
                .role(role)
                .status(status)
                .build();
    }
}
