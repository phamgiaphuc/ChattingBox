package com.example.ChattingBox.service;

import com.example.ChattingBox.models.SubjectModel;
import com.example.ChattingBox.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<SubjectModel> testingRoute() {
        return subjectRepository.findAll();
    }

    public void addNewSubject(SubjectModel newSubject) {
        Optional<SubjectModel> subjectById = subjectRepository.findBySubjectId(newSubject.getSubject_id());
        if (subjectById.isPresent()) {
            throw new IllegalStateException("Subject id is taken!");
        }
        subjectRepository.save(newSubject);
    }
}
