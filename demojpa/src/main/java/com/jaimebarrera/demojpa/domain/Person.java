package com.jaimebarrera.demojpa.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "personas")
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", columnDefinition = "TEXT", length = 50, nullable = false)       
    private String name;
    private String lastName;

    @Column(name = "programming_language")
    private String language;

    @ManyToOne
    @JoinColumn(name = "rol_id", nullable = false)
    @JsonBackReference  // Marca el lado que no serializa
    private Rol rol;

    public Person(){

    }

    public Person(Long id, String name, String lastName, String language) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.language = language;
    }

    
}
