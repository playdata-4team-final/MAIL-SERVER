package com.example.mailserver.mail.service;

import com.example.mailserver.global.dto.MailDto;
import com.example.mailserver.global.exception.NotFoundException;
import com.example.mailserver.mail.entity.Mail;
import com.example.mailserver.mail.entity.MemberEntity;
import com.example.mailserver.mail.entity.request.*;
import com.example.mailserver.mail.entity.response.MailRes;
import com.example.mailserver.mail.entity.response.MemberRes;
import com.example.mailserver.mail.repository.MailRepository;
import com.example.mailserver.mail.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final MailRepository mailRepository;
    private final MemberRepository memberRepository;

    //쪽지 보내기
    public MailRes sendMail(SendRequest request){

        MemberEntity memberEntity = memberRepository.findByUserEmail(request.getReceiverEmail()).orElse(null);
        if(memberEntity != null) {
            Mail save = mailRepository.save(request.toEntity());
            MailRes mailRes = new MailRes(save);
            return mailRes;
        } else {
            throw new NotFoundException("해당 유저가 없습니다.");
        }
    };

    //쪽지 제목 보기
    public List<MailRes> getAllMail(GetRequest getRequest){
        List<MailDto> mailDtoList = mailRepository.findAllByReceiverId(getRequest.getReceiverEmail(), getRequest.getMajorId()).get();

        List<MailRes> resultList = new ArrayList<>();
        for(MailDto mail : mailDtoList){
            resultList.add(new MailRes(mail.toEntity()));
        }

        return resultList;
    };

    //쪽지 내용보기
    public MailRes getMailMessage(GetMessageRequest getMessageRequest){
        MailDto mailDto = mailRepository.findMessageById(getMessageRequest.getId()).get();
        MailRes mailRes = new MailRes(mailDto.toEntity());
        return mailRes;
    }
    
    //단체 쪽지 보내기(관리자)
    public String sendGroupMailToAllUsers(SendGroupRequest request) {
        List<MemberEntity> members = memberRepository.findAll();


        for (MemberEntity member : members) {
            MailRes mail = new MailRes(Mail.builder().senderEmail(request.getSenderEmail()).build());
            mail.setReceiverEmail(member.getId().toString());
            mail.setSendTime(LocalDateTime.now());
            mail.setMessage(request.getMessage());

            // 메일 저장
            Mail savedMail = mailRepository.save(mail.toEntity());
        }
        return "Success Send!";
    }


    //단체 쪽지 보내기(교수)
    public MailRes sendGroupMailByProfessor(SendGroupRequest request){

        Mail save = mailRepository.save(request.toEntity());
        MailRes mailRes = new MailRes(save);
        return mailRes;
    };
    
    //메일 삭제
    @Transactional
    public String deleteMails(DeleteRequest deleteRequest) {
            mailRepository.deleteMailByIdsQuery(deleteRequest.getMailIds());
            return "Success Delete!";
    }


}
