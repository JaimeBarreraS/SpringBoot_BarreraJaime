package com.jaimebarrera.demojpa.application.service;

import java.util.List;
import com.jaimebarrera.demojpa.domain.dto.PersonRequest;
import com.jaimebarrera.demojpa.domain.dto.PersonResponse;


public interface PersonService {
    public List<PersonResponse> findAllUsersByFilter(String filter, String value);
    public PersonResponse patchPerson(Long id, PersonRequest personDto); 
    public PersonResponse createNewUser(PersonRequest personDto);  //PersonResponse
}
