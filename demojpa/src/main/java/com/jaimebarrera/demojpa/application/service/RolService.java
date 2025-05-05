package com.jaimebarrera.demojpa.application.service;

import java.util.List;

import com.jaimebarrera.demojpa.domain.Rol;

public interface RolService {
    public List<Rol> findAllRolesByFilter(String filter, String value);
    public Rol createNewRol(String name);
    public Rol removeRol(Long id);
}
