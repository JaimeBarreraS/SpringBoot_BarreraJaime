package com.jaimebarrera.demojpa.infrastructure.controller;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.application.service.PersonService;
import com.jaimebarrera.demojpa.domain.Person;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    //@Qualifier("personServicePImpl")
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")
    public List<Person> findAll(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        
        List<Person> results = personService.findAllByFilter(filter, value);
    
        return results;
    }

}
