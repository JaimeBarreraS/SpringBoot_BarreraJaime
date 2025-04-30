package com.jaimebarrera.demojpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarrera.demojpa.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
    
} 
