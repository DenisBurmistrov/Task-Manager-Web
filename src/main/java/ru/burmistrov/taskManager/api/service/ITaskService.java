package ru.burmistrov.taskManager.api.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.burmistrov.taskManager.entity.Task;

import java.util.List;

public interface ITaskService {

    Task save(@NotNull final Task task);

    void delete(@NotNull final Task task);

    @Nullable
    Task findOne(@NotNull final String id, @NotNull final String userId);

    @Nullable
    List<Task> findAllByProjectId(@NotNull final String userId, @NotNull final String projectId);
}