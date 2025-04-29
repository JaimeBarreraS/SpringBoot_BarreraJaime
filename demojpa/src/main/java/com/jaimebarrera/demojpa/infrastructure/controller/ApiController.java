package com.jaimebarrera.demojpa.infrastructure.controller;

import java.util.List;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.application.service.PersonService;
import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.domain.Rol;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    
    public ApiController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/users")
    public List<Person> findAllUser(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        
        List<Person> results = personService.findAllUsersByFilter(filter, value);
    
        return results;
    }

    @GetMapping("/roles")
    public List<Rol> findAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        
        List<Rol> results = personService.findAllRolesByFilter(filter, value);
    
        return results;
    }

}
