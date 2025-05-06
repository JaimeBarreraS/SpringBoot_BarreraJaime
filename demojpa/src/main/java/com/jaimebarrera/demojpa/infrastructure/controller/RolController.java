package com.jaimebarrera.demojpa.infrastructure.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jaimebarrera.demojpa.application.service.RolService;
import com.jaimebarrera.demojpa.domain.Rol;
import com.jaimebarrera.demojpa.domain.RoleRequest;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    //listar Roles
    @GetMapping("/roles")
    public List<Rol> findAllRoles(
        @RequestParam(name = "filter", defaultValue = "") String filter,
        @RequestParam(name = "value", defaultValue = "") String value
    ) {
        List<Rol> results = rolService.findAllRolesByFilter(filter, value);
        return results;
    }

    //Crear Roles
    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Rol newRole(@Valid @RequestBody RoleRequest rol) {
        return rolService.createNewRol(rol.getName());
    }

    //Eliminar Roles
    @DeleteMapping("/roles/{id}")
    public ResponseEntity<Rol> removeRol(@PathVariable (name="id") Long id) {
        return ResponseEntity.ok().body(rolService.removeRol(id));
    }
}

    

