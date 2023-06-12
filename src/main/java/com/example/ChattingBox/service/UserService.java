package com.example.ChattingBox.service;

import com.example.ChattingBox.models.UserModel;
import com.example.ChattingBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public List<UserModel> testingRoute() {
        return userRepository.findAll();
    }
}
