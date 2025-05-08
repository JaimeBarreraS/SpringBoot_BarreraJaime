package com.taller.taller.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "operation")
@Getter
@Setter
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;


    @OneToMany(mappedBy = "operation", cascade = CascadeType.ALL)
    private List<GrantedPermission> grantedPermissions;

    @Column(nullable = false)
    private boolean permit_all;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id", nullable = false)
    @JsonBackReference
    private Module module; 

    
    private String http_method;
    private String name;
    private String path;

    public Operation() {}

    public Operation(Long id, boolean permit_all, String http_method, String name, String path) {
        this.id = id;
        this.permit_all = permit_all;
        this.http_method = http_method;
        this.name = name;
        this.path = path;
    }

}
