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
@Table(name = "subchapters")
@Getter
@Setter
public class SubChapters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id", nullable = false) 
    private Chapters chapter;
    

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String summary;

    public SubChapters() {}

    public SubChapters(Long id, String description, String summary) {
        this.id = id;
        this.description = description;
        this.summary = summary;
    }
    

}
