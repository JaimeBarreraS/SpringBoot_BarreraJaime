package com.jaimebarrera.demojpa.application.service;

import java.util.List;

import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.domain.Rol;


public interface PersonService {
    public List<Person> findAllUsersByFilter(String filter, String value); 
    public List<Rol> findAllRolesByFilter(String filter, String value);
}
