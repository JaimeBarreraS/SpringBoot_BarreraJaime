package com.taller.taller.domain;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "test_config")
@Getter
@Setter
public class TestConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "test_config", cascade = CascadeType.ALL)
    private List<Exams> exams;

    @OneToMany(mappedBy = "test_config", cascade = CascadeType.ALL)
    private List<TestQuestions> test_questions;

    private Date end_date;
    private boolean is_active;
    private int score;
    private Date start_date;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String test_summary;

    public TestConfig() {
    }

    public TestConfig(Long id, Date end_date, boolean is_active, int score, Date start_date, String description,
            String test_summary) {
        this.id = id;
        this.end_date = end_date;
        this.is_active = is_active;
        this.score = score;
        this.start_date = start_date;
        this.description = description;
        this.test_summary = test_summary;
    }

}
