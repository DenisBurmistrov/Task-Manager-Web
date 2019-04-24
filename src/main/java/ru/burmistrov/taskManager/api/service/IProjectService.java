package ru.burmistrov.taskManager.api.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.burmistrov.taskManager.entity.Project;

import java.util.List;

public interface IProjectService {

    Project save(@NotNull final Project project);

    void delete(@NotNull final Project project);

    List<Project> findAll(@NotNull final String userId);

    Project findOne(@NotNull final String id, @NotNull final String userId);
}

