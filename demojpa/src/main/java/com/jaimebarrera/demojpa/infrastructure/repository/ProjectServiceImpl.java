package com.jaimebarrera.demojpa.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jaimebarrera.demojpa.application.service.ProjectService;
import com.jaimebarrera.demojpa.domain.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }



}
