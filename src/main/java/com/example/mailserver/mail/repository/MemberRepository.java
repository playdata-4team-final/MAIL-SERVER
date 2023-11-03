package com.example.mailserver.mail.repository;


import com.example.mailserver.mail.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {
    Optional<MemberEntity> findByUserId(String userId);
}
