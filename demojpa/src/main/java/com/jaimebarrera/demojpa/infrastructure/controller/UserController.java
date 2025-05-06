package com.jaimebarrera.demojpa.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.application.service.PersonService;
import com.jaimebarrera.demojpa.domain.dto.PersonRequest;
import com.jaimebarrera.demojpa.domain.dto.PersonResponse;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final PersonService personService;

    public UserController(PersonService personService) {
        this.personService = personService;
    }

    //listar usuarios
    @GetMapping("/users")
    public List<PersonResponse> findAllUser(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        List<PersonResponse> results = personService.findAllUsersByFilter(filter, value);
        return results;
    }

    //Crear usuario
    @PostMapping("/users")
    public ResponseEntity<PersonResponse> createNewUser(@Valid 
    @RequestBody PersonRequest personDto) {
        return new ResponseEntity<PersonResponse>(
            personService.createNewUser(personDto),
            HttpStatusCode.valueOf(201));
    }

    //Actulizar usuario
    @PatchMapping("/users/{id}")
    public ResponseEntity<PersonResponse> parcialUpdatePerson(@PathVariable Long id, @RequestBody PersonRequest personDto) {
        //return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(personService.patchPerson(id, personDto));
    }

}
