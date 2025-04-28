package com.jaimebarrera.demojpa.application.service;

import java.util.List;

import com.jaimebarrera.demojpa.domain.Person;


public interface PersonService {
    public List<Person> findAllByFilter(String filter, String value); 
}
