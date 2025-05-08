package com.taller.taller.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
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
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL) // nivel de JPA
    @JoinColumn(name = "role_id", nullable = false) 
    @JsonBackReference // Marca el lado que no serializa 
    private Rol role; 
    
    private String name;    
    private String password;
    private String username;

    public User() {}

    public User(Long id, Rol role, String name, String password, String username) {
        this.id = id;
        this.role = role;
        this.name = name;
        this.password = password;
        this.username = username;
    }


}
