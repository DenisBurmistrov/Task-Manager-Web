package ru.burmistrov.TaskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.api.repository.ITaskRepository;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.entity.Task;
import ru.burmistrov.TaskManager.loader.Bootstrap;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TaskRepository implements ITaskRepository {

    @Nullable private static TaskRepository instance;

    @NotNull private Map<String, Task> tasks = Bootstrap.getTasks();

    @NotNull
    public static TaskRepository getInstance() {
        if(instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

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
            if(task.getId().equals(projectId)) {
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
