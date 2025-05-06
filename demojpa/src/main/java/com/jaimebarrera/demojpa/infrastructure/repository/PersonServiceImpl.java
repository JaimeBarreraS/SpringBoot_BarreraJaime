package com.jaimebarrera.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jaimebarrera.demojpa.application.service.PersonService;
import com.jaimebarrera.demojpa.domain.Passport;
import com.jaimebarrera.demojpa.domain.Person;
import com.jaimebarrera.demojpa.domain.Rol;
import com.jaimebarrera.demojpa.domain.dto.PersonRequest;
import com.jaimebarrera.demojpa.domain.dto.PersonResponse;
import com.jaimebarrera.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;  
    private final DocumentRepository documentRepository;

    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository, DocumentRepository documentRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<PersonResponse> findAllUsersByFilter(String filter, String value) {
        if(filter.toLowerCase().equals("name") && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        } else if(filter.toLowerCase().equals("language")  && !value.isEmpty()) {
            return personRepository.findAll().stream().map((person) -> {
                PersonResponse response = new PersonResponse();
                response.setName(person.getName());
                response.setSurname(person.getLastName());
                response.setSkill(person.getLanguage());
                response.setPassport(person.getPassport() != null);
                return response;
            }).toList();
        } 
        return personRepository.findAll().stream().map((person) -> {
            PersonResponse response = new PersonResponse();
            response.setName(person.getName());
            response.setSurname(person.getLastName());
            response.setSkill(person.getLanguage());
            response.setPassport(person.getPassport() != null);
            return response;
        }).toList();
    }

    @Override
    public PersonResponse patchPerson(Long id, PersonRequest personDto) {
       Person person = personRepository.findById(id)
       .orElseThrow(() -> new EntityNotFoundException("No se encontro el usuario solicitado"));
        
        if(personDto.getName() != null) {
            person.setName(personDto.getName());
        }

        if(personDto.getSurname() != null) {
            person.setLanguage(personDto.getSkill());
        }

        if (personDto.getSkill() != null) {
            person.setLanguage(personDto.getSkill());
        }

        personRepository.save(person);

        PersonResponse response = new PersonResponse();
        response.setName(person.getName());
        response.setSurname(person.getLastName());
        response.setSkill(person.getLanguage());
        response.setPassport(person.getPassport() != null);
        return response;

    }


    @Override
    public PersonResponse createNewUser(PersonRequest personDto) {
        Optional<Person> person = personRepository.findPersonByPassportNumber(personDto.getPassport());

        // Verificar si el pasaporte ya existe
        if (person.isPresent()) {
            throw new RolDuplicateException("Ya el usuario se encuentra registrado", HttpStatus.CONFLICT);
        }

        // Buscar el rol por defecto
        Rol userRol = roleRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("No se encontra el rol por defecto"));
        
        // Crear el usuario y el pasaporte  temporalmente
        Person newPerson = new Person();
        newPerson.setName(personDto.getName());
        newPerson.setLastName(personDto.getSurname());
        newPerson.setLanguage(personDto.getSkill());
        newPerson.setRol(userRol);

        // Guardar el pasaporte y el usuario
        Person save = personRepository.save(newPerson);

        Passport passport = new Passport();
        passport.setPerson(save);
        passport.setNumber(personDto.getPassport());

        documentRepository.save(passport);

        save.setPassport(passport);

        // Guardar el pasaporte
        PersonResponse response = new PersonResponse();
            response.setName(save.getName());
            response.setSurname(save.getLastName());
            response.setSkill(save.getLanguage());
            response.setPassport(save.getPassport() != null);
            return response;
 
    }
}
