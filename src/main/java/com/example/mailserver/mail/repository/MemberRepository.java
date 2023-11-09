package com.example.mailserver.mail.repository;


import com.example.mailserver.mail.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<MemberEntity, UUID> {
    Optional<MemberEntity> findByUserId(String userId);

    @Query("select m from MemberEntity as m where m.email =:userEmail")
   Optional<MemberEntity> findByUserEmail(@Param("userEmail") String userEmail);
}
