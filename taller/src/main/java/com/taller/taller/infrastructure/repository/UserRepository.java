package com.taller.taller.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller.taller.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    
} 