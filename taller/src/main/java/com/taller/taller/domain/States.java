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
@Table(name = "states")
@Getter
@Setter
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    private Countries country;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<Cities> cities;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String abbreviation;

    @Column(nullable = false)
    private String name_state;
    

    public States() {
    }

    public States(Long id, Countries country, Timestamp created_at, Timestamp updated_at, String abbreviation,
            String name_state) {
        this.id = id;
        this.country = country;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.abbreviation = abbreviation;
        this.name_state = name_state;
    }

}
