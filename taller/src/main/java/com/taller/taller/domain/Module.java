package com.taller.taller.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "module")
@Getter
@Setter
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    @JsonManagedReference // Marca el lado que si serializa
    private List<Operation> operations;

    private String base_path;
    private String name;

    public Module() {}

    public Module(Long id, String base_path, String name) {
        this.id = id;
        this.base_path = base_path;
        this.name = name;
    }

}
