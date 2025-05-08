package com.taller.taller.domain;

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
@Table(name = "test_questions")
@Getter
@Setter
public class TestQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private Questions questions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testconf_id", nullable = false)
    private TestConfig test_config;

    public TestQuestions() {
    }

    public TestQuestions(Long id, Questions questions, TestConfig test_config) {
        this.id = id;
        this.questions = questions;
        this.test_config = test_config;
    }

}
