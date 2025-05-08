package com.taller.taller.domain;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "schools")
@Getter
@Setter
public class Schools {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "schools", cascade = CascadeType.ALL)
    private Cities cities;

    @OneToMany(mappedBy = "schools", cascade = CascadeType.ALL)
    private List<Students> students;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String description_school;

    @Column(nullable = false)
    private String headmaster_school;

    @Column(nullable = false)
    private String celphone_school;

    @Column(nullable = false)
    private String email_school;

    public Schools () {}

    public Schools(Long id, Cities cities, Timestamp created_at, Timestamp updated_at, String description_school,
            String headmaster_school, String celphone_school, String email_school) {
        this.id = id;
        this.cities = cities;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.description_school = description_school;
        this.headmaster_school = headmaster_school;
        this.celphone_school = celphone_school;
        this.email_school = email_school;
    }

    


}
