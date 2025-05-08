package com.taller.taller.domain;

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
@Table(name = "type_questions")
@Getter
@Setter
public class TypeQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "type_questions", cascade = CascadeType.ALL)
    private List<Questions> questions;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String tag_option;

    public TypeQuestions() {
    }

    public TypeQuestions(Long id, String description, String tag_option) {
        this.id = id;
        this.description = description;
        this.tag_option = tag_option;
    }

}
