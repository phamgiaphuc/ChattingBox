package com.example.ChattingBox.service;

import com.example.ChattingBox.models.SubjectModel;
import com.example.ChattingBox.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    public void deleteSubject(Long subjectId) {
        boolean exists = subjectRepository.existsById(subjectId);
        if (!exists) {
            throw new IllegalStateException("Subject with id " + subjectId + " does not exists");
        }
        subjectRepository.deleteById(subjectId);
    }

    @Transactional
    public void updateSubject(Long id, String subjectId, String subjectName) {
        SubjectModel subjectModel = subjectRepository.findById(id).orElseThrow(() ->
            new IllegalStateException("Subject with id " + subjectId + " does not exists")
        );
        // Update the subject id
        if (subjectId != null && subjectId.length() > 0 && !Objects.equals(subjectId, subjectModel.getSubject_id())) {
            subjectModel.setSubject_id(subjectId);
        }
        // Update the subject name
        if (subjectName != null && subjectName.length() > 0 && !Objects.equals(subjectName, subjectModel.getSubject_name())) {
            subjectModel.setSubject_name(subjectName);
        }
        // Update time
        subjectModel.setUpdated_date(LocalDate.now());
    }
}
