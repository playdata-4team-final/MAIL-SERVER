package com.example.mailserver.member.controller;


import com.example.mailserver.global.domain.response.LmsResponse;
import com.example.mailserver.member.MemberEntity;
import com.example.mailserver.member.repository.MemberRepository;
import com.example.mailserver.member.request.MemberRequest;
import com.example.mailserver.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LmsResponse<MemberEntity> saveMember(@RequestBody MemberRequest request){
        MemberEntity memberEntity = memberService.saveMember(request);
        return new LmsResponse<>(HttpStatus.OK, memberEntity, "서비스 성공", "", LocalDateTime.now());

    }

    @GetMapping("/{id}")
    public LmsResponse<MemberEntity> getMember(@PathVariable("id")String id){
        MemberEntity member = memberService.getMember(id);
        return new LmsResponse<>(HttpStatus.OK, member, "서비스 성공", "", LocalDateTime.now());
    }

}
