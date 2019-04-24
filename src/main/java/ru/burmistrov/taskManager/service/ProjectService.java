package ru.burmistrov.taskManager.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.burmistrov.taskManager.api.service.IProjectService;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.repository.IProjectRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    public Project save(@NotNull final Project project){
        return projectRepository.save(project);
    }

    public void delete(@NotNull final Project project){
        projectRepository.delete(project);
    }

    public List<Project> findAll(@NotNull final String userId){
        List<Project> projects = projectRepository.findAll(userId);
        if(projects == null) return new ArrayList<>();
        return projectRepository.findAll(userId);
    }

    public Project findOne(final String id, final String userId){
        return projectRepository.findOne(id, userId);
    }
}
