package ru.burmistrov.taskManager.api.repository;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.taskManager.entity.Project;

import java.util.List;

public interface IProjectRepository{

    @Nullable
    Project persist(@NotNull final Project project);

    void remove(@NotNull final String id);

    @NotNull
    List<Project> findAll(String userId);

    @Nullable
    Project findOne(@NotNull final String id);

    @Nullable
    Project merge(@NotNull final Project project);
}
