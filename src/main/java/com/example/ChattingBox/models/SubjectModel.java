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
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

@Entity
@NotNull
@Table(name = "subject")
@Data
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
}
