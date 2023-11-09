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

    @Query("select m from Mail as m where m.receiverEmail = :receiverEmail or m.majorId = :majorId")
    Optional<List<MailDto>> findAllByReceiverId(@Param("receiverEmail") String receiverEmail, @Param("majorId")Long majorId);

    @Query("select m.message from Mail as m where m.id = :id")
    Optional <MailDto> findMessageById(@Param("id")Long id);

    @Modifying
    @Query("DELETE FROM Mail m WHERE m.id IN :ids")
    void deleteMailByIdsQuery(@Param("ids") List<Long> mailIds);

}
