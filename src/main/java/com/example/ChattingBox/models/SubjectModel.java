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
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@NotNull
@Table(name = "subject")
public class SubjectModel {
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    // Variables
    @Id
    private int id;

    @Column(unique = true)
    private String subject_id;

    private String subject_name;

    @CreatedDate
    private LocalDate created_date = LocalDate.now();

    @LastModifiedDate
    private LocalDate updated_date = LocalDate.now();

    public SubjectModel() {

    }

    public SubjectModel(int id, String subject_id, String subject_name, LocalDate created_date, LocalDate updated_date) {
        this.id = id;
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.created_date = created_date;
        this.updated_date = updated_date;
    }

    public SubjectModel(String subject_id, String subject_name) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setSubject_id(String subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_id() {
        return subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }
}
