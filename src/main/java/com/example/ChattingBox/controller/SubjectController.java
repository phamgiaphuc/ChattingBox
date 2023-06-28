package com.example.ChattingBox.controller;

import com.example.ChattingBox.models.SubjectModel;
import com.example.ChattingBox.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/chatting-box/api/subject")
public class SubjectController {
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping(path = "/infos")
    public List<SubjectModel> testingRoute() {
        return subjectService.testingRoute();
    }

    @PostMapping(path = "/register")
    public String registerNewSubject(@RequestBody SubjectModel newSubject) {
        subjectService.addNewSubject(newSubject);
        return "Add new subject successful!";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteSubject(@PathVariable("id") long id) {
        subjectService.deleteSubject(id);
        return "Delete the account with id " + id + " successful!";
    }

    @PutMapping(path = "/update/{id}")
    public String updateSubject(@PathVariable("id") long id, @RequestParam(required = false) String subjectId, @RequestParam(required = false) String subjectName) {
        subjectService.updateSubject(id, subjectId, subjectName);
        return "Update the account with id " + id + " successful!";
    }
}
