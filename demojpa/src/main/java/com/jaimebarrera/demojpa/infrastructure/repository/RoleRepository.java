package com.jaimebarrera.demojpa.infrastructure.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarrera.demojpa.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);
} 

