package com.jaimebarrera.demojpa.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jaimebarrera.demojpa.application.service.RolService;
import com.jaimebarrera.demojpa.domain.Rol;
import com.jaimebarrera.demojpa.infrastructure.error.RolDuplicateException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RolServiceImpl implements RolService {

    private final RoleRepository roleRepository;

    public RolServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public Rol removeRol(Long id) {
        Optional<Rol> rol = roleRepository.findById(id);

        if(!rol.isPresent()) {
            throw new EntityNotFoundException("El rol no se encuentra registrado");
        }

        if (!rol.get().getPersons().isEmpty()) {
            throw new EntityNotFoundException("El rol se encuentra asociado a un usuario");
            
        }

        /*
         * if(rol.isPresent() && rol.get().getPersons().isEmpty()) {
            roleRepository.deleteById(id);
            //roleRepository.delete(rol.get());
            return rol.get();
        }
         */

        roleRepository.deleteById(id);
        return rol.get();
        

        //throw new EntityNotFoundException("El rol no se encuentra registrado");
    }

    @Override
    public List<Rol> findAllRolesByFilter(String filter, String value) { 
        return roleRepository.findAll();
    }

    @Override
    public Rol createNewRol(String name) {
        Rol newRol = new Rol();
        newRol.setName(name);

        if(getRolByName(name).isPresent())
        {
            throw new RolDuplicateException("El Rol "+ name + " ya existe", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return roleRepository.save(newRol);

    }

    private Optional<Rol> getRolByName(String rolName) {
        return roleRepository.findByName(rolName);
    }

}
