package com.example.ChattingBox.repository;

import com.example.ChattingBox.models.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
    @Query("SELECT subject FROM SubjectModel subject WHERE subject.subject_id = ?1")
    Optional<SubjectModel> findBySubjectId(String subject_id);
}
