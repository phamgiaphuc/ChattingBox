package com.example.ChattingBox.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@NotNull
@Table(name = "user_account")
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
    // Declare variables
    @Id
    private long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @CreatedDate
    private LocalDate createdDate = LocalDate.now();

    public UserModel(long id, String name, String password, String email, LocalDate createdDate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdDate = createdDate;
    }

    public UserModel(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public UserModel() {

    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate dateCreated) {
        this.createdDate = dateCreated;
    }

    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", created date=" + createdDate + "}";
    }
}