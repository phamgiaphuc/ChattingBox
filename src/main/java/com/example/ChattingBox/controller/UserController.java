package com.example.ChattingBox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/chatting-box/api/user")
@RequiredArgsConstructor
public class UserController {
    @GetMapping(path = "/testing")
    public String testApp() {
        return "Chatting Box - Testing Route";
    }
}
