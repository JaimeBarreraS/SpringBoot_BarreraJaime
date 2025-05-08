package com.taller.taller.domain;

import java.sql.Timestamp;
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
@Table(name = "cities")
@Getter
@Setter
public class Cities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id", nullable = false)
    private States state;

    @OneToMany(mappedBy = "cities", cascade = CascadeType.ALL)
    private List<Schools> schools;

    @OneToMany(mappedBy = "cities", cascade = CascadeType.ALL)
    private List<Students> students;

    private String state_abbreviation;
    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String name_city;

    public Cities (){}

    public Cities(Long id, States state, List<Schools> schools, String state_abbreviation, Timestamp created_at,
            Timestamp updated_at, String name_city) {
        this.id = id;
        this.state = state;
        this.schools = schools;
        this.state_abbreviation = state_abbreviation;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.name_city = name_city;
    }

    

}
