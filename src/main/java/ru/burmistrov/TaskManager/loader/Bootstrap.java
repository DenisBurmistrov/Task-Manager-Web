package ru.burmistrov.TaskManager.loader;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.entity.Task;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    @NotNull static private final Map<String, Project> projects = new HashMap<>();

    @NotNull static private final Map<String, Task> tasks = new HashMap<>();

    private Bootstrap() {
    }

    public static Map<String, Project> getProjects(){
        if(projects.size() == 0) {
            initProjectsAndTasks();
        }
        return projects;
    }

    public static Map<String, Task> getTasks(){
        if(tasks.size() == 0) {
            initProjectsAndTasks();
        }
        return tasks;
    }

    private static void initProjectsAndTasks(){
        Project project1 = new Project("First Project", "First Description", new Date());
        Project project2 = new Project("Second Project", "Second Description", new Date());
        Task task1 = new Task(project1.getId() ,"First Task", "First Description", new Date());
        Task task2 = new Task(project2.getId() ,"Second Task", "Second Description", new Date());

        projects.put(project1.getId(), project1);
        projects.put(project2.getId(), project2);

        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
    }
}
