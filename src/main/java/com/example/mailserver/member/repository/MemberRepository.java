package com.example.mailserver.member.repository;


import com.example.mailserver.member.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {


    @Query("SELECT m.majorName FROM MemberEntity AS m where m.name = :name")
    Optional<MemberEntity> findByUserIdAndGetMajorName(@Param("name")String name);

    @Query("select m from MemberEntity as m where m.userId =:userId")
   Optional<MemberEntity> findByUserId(@Param("userId") String userId);

}
