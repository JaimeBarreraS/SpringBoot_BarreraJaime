package com.taller.taller.domain;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private boolean is_correct;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private Questions questions;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String description;

    public Answers() {
    }

    public Answers(Long id, boolean is_correct, Questions questions, Timestamp created_at, Timestamp updated_at,
            String description) {
        this.id = id;
        this.is_correct = is_correct;
        this.questions = questions;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
    }


}
