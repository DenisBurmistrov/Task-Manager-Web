package ru.burmistrov.taskManager.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.burmistrov.taskManager.api.service.ITaskService;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.repository.ITaskRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public Task save(@NotNull final Task task){
        return taskRepository.save(task);
    }

    public void delete(@NotNull final Task task){
        taskRepository.delete(task);
    }

    public Task findOne(@NotNull final String id, @NotNull final String userId) {
      return taskRepository.findOne(id, userId);
    }

    public List<Task> findAllByProjectId(@NotNull final String userId, @NotNull final String projectId) {
        List<Task> tasks = taskRepository.findAllByProjectId(userId, projectId);
        if(tasks == null) return new ArrayList<>();
        return taskRepository.findAllByProjectId(userId, projectId);
    }
}
