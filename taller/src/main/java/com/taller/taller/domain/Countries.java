package com.taller.taller.domain;

import java.sql.Timestamp;
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
@Table(name = "countries")
@Getter
@Setter
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    private List<States> states;

    private Timestamp created_at;
    private Timestamp updated_at;

    @Column(nullable = false)
    private String country_name;

    public Countries() {
    }

    public Countries(Long id, Timestamp created_at, Timestamp updated_at, String country_name) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.country_name = country_name;
    }

}
