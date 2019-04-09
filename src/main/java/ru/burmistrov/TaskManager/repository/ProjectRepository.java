package ru.burmistrov.TaskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.api.repository.IProjectRepository;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.loader.Bootstrap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    @Nullable
    private static ProjectRepository instance;

    @NotNull private Map<String, Project> projects = Bootstrap.getProjects();

    @NotNull
    public static ProjectRepository getInstance() {
        if(instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    private ProjectRepository() {
    }

    @Nullable
    @Override
    public Project persist(@NotNull Project project) {
        return projects.put(project.getId(), project);
    }

    @Override
    public void remove(@NotNull String id) {
        projects.remove(id);
    }

    @NotNull
    @Override
    public List<Project> findAll() {
        return new LinkedList<>(projects.values());
    }

    @Nullable
    @Override
    public Project findOne(@NotNull String id) {
        return projects.get(id);
    }

    @Nullable
    @Override
    public Project merge(@NotNull Project project) {
        return projects.put(project.getId(), project);
    }
}
