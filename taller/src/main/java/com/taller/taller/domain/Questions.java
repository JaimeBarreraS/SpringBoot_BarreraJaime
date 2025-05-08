package com.taller.taller.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private int score;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeoption_id", nullable = false)
    private TypeQuestions type_questions;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<TestQuestions> test_questions;

    @OneToMany(mappedBy = "questions", cascade = CascadeType.ALL)
    private List<Answers> answers;

    @Column(nullable = false)
    private String description;

    public Questions() {
    }

    public Questions(Long id, int score, TypeQuestions type_questions, String description) {
        this.id = id;
        this.score = score;
        this.type_questions = type_questions;
        this.description = description;
    }

}
