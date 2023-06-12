package com.example.ChattingBox.repository;

import com.example.ChattingBox.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    @Query("SELECT user FROM UserModel user WHERE user.email = ?1")
    Optional<UserModel> findUserByEmail(String email);
}
