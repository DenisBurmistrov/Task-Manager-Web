package ru.burmistrov.taskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.burmistrov.taskManager.api.repository.ITaskRepository;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.loader.Bootstrap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class TaskRepository implements ITaskRepository {

    @Autowired
    private Bootstrap bootstrap;

    @NotNull private Map<String, Task> tasks = bootstrap.getTasks();

    @Nullable
    @Override
    public Task persist(@NotNull Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public void remove(@NotNull String id) {
        tasks.remove(id);
    }

    @NotNull
    @Override
    public List<Task> findAll(@NotNull final String projectId) {
        @NotNull final List<Task> result = new LinkedList<>();
        for (Task task : tasks.values()){
            if(Objects.requireNonNull(task.getProjectId()).equals(projectId)) {
                result.add(task);
            }
        }
        return result;
    }

    @Nullable
    @Override
    public Task findOne(@NotNull String id) {
        return tasks.get(id);
    }

    @Nullable
    @Override
    public Task merge(@NotNull Task task) {
        return tasks.put(task.getId(), task);
    }
}
