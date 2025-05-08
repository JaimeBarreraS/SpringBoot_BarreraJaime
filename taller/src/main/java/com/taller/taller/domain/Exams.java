package com.taller.taller.domain;

import java.sql.Date;

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
@Table(name = "exams")
@Getter
@Setter
public class Exams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Date date_presentation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", nullable = false)
    private Students students;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "testconf_id", nullable = false)
    private TestConfig test_config;

    public Exams() {
    }

    public Exams(Long id, Date date_presentation, Students students, TestConfig test_config) {
        this.id = id;
        this.date_presentation = date_presentation;
        this.students = students;
        this.test_config = test_config;
    }

}
