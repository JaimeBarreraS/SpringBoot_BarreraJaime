package com.jaimebarrera.demojpa.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.repository.PersonRepository;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonRepository personRepository;
    
    public ApiController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping("/users")
    public List<Person> findAll() {

        List<Person> results = personRepository.findByLanguageEquals("Java");
    
        return results;
    }

}
