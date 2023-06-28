package com.example.ChattingBox.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@NotNull
@Table(name = "user_account")
@Data
public class UserModel {
    @SequenceGenerator(
            name = "user_account_sequence",
            sequenceName = "user_account_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_account_sequence"
    )
    // Variables
    @Id
    private long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDate createdDate = LocalDate.now();
}