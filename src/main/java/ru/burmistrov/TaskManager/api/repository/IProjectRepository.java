package ru.burmistrov.TaskManager.api.repository;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.entity.Project;

import java.util.List;

public interface IProjectRepository{

    @Nullable
    Project persist(@NotNull final Project project);

    void remove(@NotNull final String id);

    @NotNull
    List<Project> findAll();

    @Nullable
    Project findOne(@NotNull final String id);

    @Nullable
    Project merge(@NotNull final Project project);
}
