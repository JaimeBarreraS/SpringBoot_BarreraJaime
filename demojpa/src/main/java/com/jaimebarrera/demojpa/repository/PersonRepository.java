package com.jaimebarrera.demojpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimebarrera.demojpa.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByNameContains(String name);
    List<Person> findByLanguageEquals(String name);

}
