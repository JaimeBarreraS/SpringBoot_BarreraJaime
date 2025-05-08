package com.taller.taller.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "granted_permission")
@Getter
@Setter
public class GrantedPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Rol role;

    @ManyToOne
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    public GrantedPermission() {
    }

    public GrantedPermission(Long id, Rol role, Operation operation) {
        this.id = id;
        this.role = role;
        this.operation = operation;
    }
}

