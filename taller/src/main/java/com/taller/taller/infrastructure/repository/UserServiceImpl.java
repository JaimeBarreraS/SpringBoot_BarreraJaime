package com.taller.taller.infrastructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taller.taller.application.service.UserService;
import com.taller.taller.domain.Rol;
import com.taller.taller.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RolRepository roleRepository; 

    public UserServiceImpl(UserRepository userRepository, RolRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        Rol role = roleRepository.findById(1L) // o según el rol que deseas
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        user.setRole(role);
        return userRepository.save(user);
    }
    

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User toUpdate = existing.get();
            toUpdate.setName(user.getName());
            toUpdate.setUsername(user.getUsername());
            return userRepository.save(toUpdate);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
    }
}

