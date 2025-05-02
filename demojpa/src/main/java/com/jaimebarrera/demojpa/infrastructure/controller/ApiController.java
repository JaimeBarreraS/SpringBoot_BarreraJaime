package com.jaimebarrera.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.application.service.PersonService;
import com.jaimebarrera.demojpa.application.service.ProjectService;
import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.domain.Project;
import com.jaimebarrera.demojpa.domain.Rol;
import com.jaimebarrera.demojpa.domain.RoleRequest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {


    private final PersonService personService;
    private final ProjectService projectService;
    
    public ApiController(PersonService personService, ProjectService projectService) {
        this.projectService = projectService;
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

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Rol newRole(@Valid @RequestBody RoleRequest rol) {
        return personService.createNewRol(rol.getName());
    }
   
    @GetMapping("/projects")
    public List<Project> findAllProjects(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        
        List<Project> results = projectService.findAllProjects();
    
        return results;
    }
}

