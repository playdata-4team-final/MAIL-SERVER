package com.example.mailserver.mail.service;

import com.example.mailserver.global.dto.MailDto;
import com.example.mailserver.mail.entity.Mail;
import com.example.mailserver.mail.entity.MemberEntity;
import com.example.mailserver.mail.entity.request.GetMessageRequest;
import com.example.mailserver.mail.entity.request.GetRequest;
import com.example.mailserver.mail.entity.request.SendGroupRequest;
import com.example.mailserver.mail.entity.request.SendRequest;
import com.example.mailserver.mail.entity.response.MailRes;
import com.example.mailserver.mail.repository.MailRepository;
import com.example.mailserver.mail.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailRepository mailRepository;
    private final MemberRepository memberRepository;

    //쪽지 보내기
    private MailRes sendMail(SendRequest request){
        Mail save = mailRepository.save(request.toEntity());
        MailRes mailRes = new MailRes(save);
        return mailRes;
    };

    //쪽지 제목 보기
    private List<MailRes> getMailAllTitles(GetRequest getRequest){
        List<MailDto> mailDtoList = mailRepository.findTitleByreceiverId(getRequest.getReceiverId()).get();

        List<MailRes> resultList = new ArrayList<>();
        for(MailDto mail : mailDtoList){
            resultList.add(new MailRes(mail.toEntity()));
        }

        return resultList;
    };

    //쪽지 내용보기
    private MailRes getMailMessage(GetMessageRequest getMessageRequest){
        MailDto mailDto = mailRepository.findMessageById(getMessageRequest.getId()).get();
        MailRes mailRes = new MailRes(mailDto.toEntity());
        return mailRes;
    }
    
    //단체 쪽지 보내기(관리자)
    public String sendGroupMailToAllUsers(SendGroupRequest request) {
        List<MemberEntity> members = memberRepository.findAll();


        for (MemberEntity member : members) {
            MailRes mail = new MailRes(Mail.builder().senderId(request.getSenderId()).build());
            mail.setReceiverId(member.getId().toString());
            mail.setSendTime(LocalDateTime.now());
            mail.setMessage(request.getMessage());

            // 메일 저장
            Mail savedMail = mailRepository.save(mail.toEntity());

        }

        return "Success Send!";
    }


    //단체 쪽지 보내기(교수)
    private MailRes sendGroupMailByProfessor(SendGroupRequest request){

        Mail save = mailRepository.save(request.toEntity());
        MailRes mailRes = new MailRes(save);
        return mailRes;
    };

    //메일 삭제
    private String deleteMail(List<GetMessageRequest> getMessageRequests){

        for(GetMessageRequest request : getMessageRequests) {
            mailRepository.deleteAllMailById(request.getId());
        }
        return "Success Delete!";
    };


}
