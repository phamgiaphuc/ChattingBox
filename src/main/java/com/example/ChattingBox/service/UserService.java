package com.example.ChattingBox.service;

import com.example.ChattingBox.models.UserModel;
import com.example.ChattingBox.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void addNewUser(UserModel newUser) {
        Optional<UserModel> userByEmail = userRepository.findUserByEmail(newUser.getEmail());
        if (userByEmail.isPresent()) {
            throw new IllegalStateException("Email is taken!");
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String bcryptPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(bcryptPassword);
        userRepository.save(newUser);
    }

    public void deleteUser(long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exists");
        }
        userRepository.deleteById(userId);
    }
}
