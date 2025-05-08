package com.taller.taller.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
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
@Table(name = "skills")
@Getter
@Setter
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<SkillRoutPath> roadPathSkills = new ArrayList<>();

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<Chapters> chapters;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String iconurl;

    @Column(nullable = false)
    private String skill_name;

    @Column(nullable = false)
    private String skill_description;

}
