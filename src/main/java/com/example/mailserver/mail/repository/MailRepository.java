package com.example.mailserver.mail.repository;

import com.example.mailserver.global.dto.MailDto;
import com.example.mailserver.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MailRepository
        extends JpaRepository<Mail,Long> {

    @Query("select m.title from Mail as m where m.receiverId = :receiverId")
    Optional<List<MailDto>> findTitleByreceiverId(@Param("receiverId") String receiverId);

    @Query("select m.message from Mail as m where m.id = :id")
    Optional <MailDto> findMessageById(@Param("id")Long id);

    @Modifying
    @Query("delete from Mail as m WHERE m.id = :id" )
    void deleteAllMailById(@Param("id")Long id);
}
