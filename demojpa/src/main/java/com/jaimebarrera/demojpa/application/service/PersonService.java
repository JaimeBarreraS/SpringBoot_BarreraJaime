package com.jaimebarrera.demojpa.application.service;

import java.util.List;

import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.domain.dto.PersonRequest;


public interface PersonService {
    public List<Person> findAllUsersByFilter(String filter, String value);
    public Person patchPerson(Long id, PersonRequest personDto); 
}
