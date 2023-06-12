package com.example.ChattingBox.config;

import com.example.ChattingBox.models.UserModel;
import com.example.ChattingBox.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            UserModel acus = new UserModel(
                    "Acus",
                    "123456",
                    "acus@gmail.com"
            );
            userRepository.save(acus);
        };
    }
}
