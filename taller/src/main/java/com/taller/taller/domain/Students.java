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
@Table(name = "students")
@Getter
@Setter
public class Students {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    private Cities cities;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id", nullable = false)
    private Schools schools;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Exams> exams;

    @Column(nullable = false)
    private String celphone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    public Students () {}

    public Students(Long id, int age, Cities cities, Schools schools, String celphone, String email, String firstname,
            String lastname) {
        this.id = id;
        this.age = age;
        this.cities = cities;
        this.schools = schools;
        this.celphone = celphone;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
    }



}
