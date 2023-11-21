package com.example.mailserver.member.service;

import com.example.mailserver.member.MemberEntity;
import com.example.mailserver.member.repository.MemberRepository;
import com.example.mailserver.member.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //회원가입 정보 저장
    @Transactional
    public MemberEntity saveMember(MemberRequest request) {
        MemberEntity save = memberRepository.save(request.toEntity());
        return save;
    }
    @Transactional
    public MemberEntity getMember(String id){
        MemberEntity find = memberRepository.findByUserId(id).get();
        return find;
    }


}
