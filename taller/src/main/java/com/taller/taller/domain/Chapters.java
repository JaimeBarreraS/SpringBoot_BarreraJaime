package com.taller.taller.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "chapters")
@Getter
@Setter
public class Chapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private int numberchapter;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_id", nullable = false)
    @JsonBackReference 
    private Skills skill;


    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String chapter_summary;

    public Chapters() {}

    public Chapters(Long id, int numberchapter, Skills skill_id, Timestamp created_at, Timestamp updated_at,
            String description, String chapter_summary) {
        this.id = id;
        this.numberchapter = numberchapter;
        this.skill = skill_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description = description;
        this.chapter_summary = chapter_summary;
    }

}
