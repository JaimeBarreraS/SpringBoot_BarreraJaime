package com.jaimebarrera.demojpa.infrastructure.repository;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarrera.demojpa.domain.Rol;

public interface RoleRepository extends JpaRepository<Rol, Long> {
    //List<Rol> findByNameContains(String name);
    //List<Rol> findByIdEquals(Long id);
} 

