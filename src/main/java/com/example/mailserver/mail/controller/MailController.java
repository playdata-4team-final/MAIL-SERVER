package com.example.mailserver.mail.controller;

import com.example.mailserver.global.domain.response.LmsResponse;
import com.example.mailserver.global.dto.MailDto;
import com.example.mailserver.mail.entity.Mail;
import com.example.mailserver.mail.entity.MemberEntity;
import com.example.mailserver.mail.entity.request.*;
import com.example.mailserver.mail.entity.response.MailRes;
import com.example.mailserver.mail.entity.response.MemberRes;
import com.example.mailserver.mail.service.MailService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MailController {

    private final MailService mailService;

    //쪽지 보내기
    @PostMapping("/sendMail")
    public LmsResponse<MailRes> sendMail(@RequestBody SendRequest request){
        MailRes mailRes = mailService.sendMail(request);
        return new LmsResponse<>(HttpStatus.OK, mailRes, " 서비스 성공", "", LocalDateTime.now());
    };

    //쪽지 정보 보기
    @PostMapping("/getAll")
    public LmsResponse<List<MailRes>> getAllMail(@RequestBody GetRequest getRequest){
        List<MailRes> allMail = mailService.getAllMail(getRequest);
        return new LmsResponse<>(HttpStatus.OK, allMail, "서비스 성공", "", LocalDateTime.now());
    };

    //쪽지 내용보기
    @GetMapping("/getMailMessage")
    public LmsResponse<MailRes> getMailMessage(@RequestBody GetMessageRequest getMessageRequest){
        MailRes mailMessage = mailService.getMailMessage(getMessageRequest);
        return new LmsResponse<>(HttpStatus.OK, mailMessage, "서비스 성공", "", LocalDateTime.now());
    }

    //단체 쪽지 보내기(관리자)
    @PostMapping("/sendGroupMailToAllUser")
    public LmsResponse<String> sendGroupMailToAllUsers(@RequestBody SendGroupRequest request) {
        String s = mailService.sendGroupMailToAllUsers(request);
        return new LmsResponse<>(HttpStatus.OK, s, "서비스 성공", "", LocalDateTime.now());

    }

    //단체 쪽지 보내기(교수)
    @PostMapping("/sendGroupMailByProfessor")
    public LmsResponse<MailRes> sendGroupMailByProfessor(@RequestBody SendGroupRequest request){

        MailRes mailRes = mailService.sendGroupMailByProfessor(request);
        return new LmsResponse<>(HttpStatus.OK, mailRes, "서비스 성공", "", LocalDateTime.now());
    };

    //메일 삭제
    @PostMapping("/deleteMails")
    public LmsResponse<String> deleteMails(@RequestBody DeleteRequest deleteRequest) {
        String s = mailService.deleteMails(deleteRequest);
        return new LmsResponse<>(HttpStatus.OK, s, "서비스 성공", "", LocalDateTime.now());
    }


}
