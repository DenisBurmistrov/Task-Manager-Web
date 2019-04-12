package ru.burmistrov.TaskManager.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.entity.Task;

import java.util.List;

public interface ITaskRepository {

    @Nullable
    Task persist(@NotNull final Task user);

    void remove(@NotNull final String id);

    @NotNull
    List<Task> findAll(@NotNull final String projectId);

    @Nullable
    Task findOne(@NotNull final String id);

    @Nullable
    Task merge(@NotNull final Task task);
}
