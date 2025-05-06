package com.jaimebarrera.demojpa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarrera.demojpa.domain.Passport;

public interface DocumentRepository extends JpaRepository<Passport, Long> {

}
