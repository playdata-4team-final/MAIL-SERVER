package com.example.mailserver.professor.repository;


import com.example.mailserver.professor.dto.ProfessorDto;
import com.example.mailserver.professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository
        extends JpaRepository<Professor, String> {
    @Query("select p from Professor as p where  p.id = :professorId")
    ProfessorDto findByProfessorId(@Param("professorId") String professorId);

}
