package ru.burmistrov.taskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.taskManager.api.repository.IProjectRepository;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.loader.Bootstrap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ProjectRepository implements IProjectRepository {

    @Nullable
    private static IProjectRepository instance;

    @NotNull private Map<String, Project> projects = Bootstrap.getProjects();

    @NotNull
    public static IProjectRepository getInstance() {
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
    public List<Project> findAll(String userId) {
        List<Project> result = new LinkedList<>();
        for(Project project : projects.values()) {
            if(project.getUserId().equals(userId)) {
                result.add(project);
            }
        }
        return result;
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
