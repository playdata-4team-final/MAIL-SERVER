package com.example.mailserver.mail.controller;

import com.example.mailserver.global.domain.response.LmsResponse;
import com.example.mailserver.global.dto.MailDto;
import com.example.mailserver.mail.entity.Mail;
import com.example.mailserver.mail.entity.MemberEntity;
import com.example.mailserver.mail.entity.request.GetMessageRequest;
import com.example.mailserver.mail.entity.request.GetRequest;
import com.example.mailserver.mail.entity.request.SendGroupRequest;
import com.example.mailserver.mail.entity.request.SendRequest;
import com.example.mailserver.mail.entity.response.MailRes;
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
public class MailController {

    private final MailService mailService;

    //쪽지 보내기
    @PostMapping("/sendMail")
    public LmsResponse<MailRes> sendMail(SendRequest request){
        MailRes mailRes = mailService.sendMail(request);
        return new LmsResponse<>(HttpStatus.OK, mailRes, "서비스 성공", "에러 없음", LocalDateTime.now());
    };

    //쪽지 제목 보기
    @GetMapping("/getMailAllTitles")
    public LmsResponse<List<MailRes>> getMailAllTitles(GetRequest getRequest){
        List<MailRes> mailAllTitles = mailService.getMailAllTitles();
        return new LmsResponse<>(HttpStatus.OK, mailAllTitles, "서비스 성공", "에러 없음", LocalDateTime.now());
    };

    //쪽지 내용보기
    @GetMapping("/getMailMessage")
    public LmsResponse<MailRes> getMailMessage(GetMessageRequest getMessageRequest){
        MailRes mailMessage = mailService.getMailMessage(getMessageRequest);
        return new LmsResponse<>(HttpStatus.OK, mailMessage, "서비스 성공", "에러 없음", LocalDateTime.now());
    }

    //단체 쪽지 보내기(관리자)
    @PostMapping("/sendGroupMailToAllUser")
    public LmsResponse<String> sendGroupMailToAllUsers(SendGroupRequest request) {
        String s = mailService.sendGroupMailToAllUsers(request);
        return new LmsResponse<>(HttpStatus.OK, s, "서비스 성공", "에러 없음", LocalDateTime.now());

    }

    //단체 쪽지 보내기(교수)
    @PostMapping("/sendGroupMailByProfessor")
    public LmsResponse<MailRes> sendGroupMailByProfessor(SendGroupRequest request){

        MailRes mailRes = mailService.sendGroupMailByProfessor(request);
        return new LmsResponse<>(HttpStatus.OK, mailRes, "서비스 성공", "에러 없음", LocalDateTime.now());
    };

    //메일 삭제
    @DeleteMapping("/deleteMail")
    public LmsResponse<String> deleteMail(List<GetMessageRequest> getMessageRequests){
        String s = mailService.deleteMail(getMessageRequests);
        return new LmsResponse<>(HttpStatus.OK, s, "서비스 성공", "에러 없음", LocalDateTime.now());
    };

}
