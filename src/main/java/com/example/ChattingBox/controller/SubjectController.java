package com.example.ChattingBox.controller;

import com.example.ChattingBox.models.SubjectModel;
import com.example.ChattingBox.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/chatting-box/api/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/testing")
    public List<SubjectModel> testingRoute() {
        return subjectService.testingRoute();
    }

    @PostMapping(path = "/register")
    public String registerNewSubject(@RequestBody SubjectModel newSubject) {
        subjectService.addNewSubject(newSubject);
        return "Done";
    }
}
