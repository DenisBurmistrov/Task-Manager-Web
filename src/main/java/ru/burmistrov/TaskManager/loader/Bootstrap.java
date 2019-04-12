package ru.burmistrov.TaskManager.loader;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.entity.Task;
import ru.burmistrov.TaskManager.entity.User;
import ru.burmistrov.TaskManager.util.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Bootstrap {

    @NotNull static private final Map<String, Project> projects = new LinkedHashMap<>();

    @NotNull static private final Map<String, Task> tasks = new LinkedHashMap<>();

    @NotNull static private final Map<String, User> users = new LinkedHashMap<>();

    private Bootstrap() {
    }

    public static Map<String, Project> getProjects(){
        if(projects.size() == 0) {
            initProjectsAndTasksAndUsers();
        }
        return projects;
    }

    public static Map<String, Task> getTasks(){
        if(tasks.size() == 0) {
            initProjectsAndTasksAndUsers();
        }
        return tasks;
    }

    public static Map<String, User> getUsers(){
        if(users.size() == 0) {
            initProjectsAndTasksAndUsers();
        }
        return users;
    }

    private static void initProjectsAndTasksAndUsers(){
        User admin = new User("admin", "admin", "admin", "admin", "admin@admin");
        User user = new User("user", "user", "user", "user", "user@user");
        try {
            admin.setHashPassword("admin");
            user.setHashPassword("user");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Project project1 = new Project("First Project", "First Description", new Date(), admin.getId());
        Project project2 = new Project("Second Project", "Second Description", new Date(), user.getId());
        Task task1 = new Task(project1.getId() ,"First Task", "First Description", new Date(), admin.getId());
        Task task2 = new Task(project2.getId() ,"Second Task", "Second Description", new Date(), user.getId());

        users.put(admin.getId(), admin);
        users.put(user.getId(), user);

        projects.put(project1.getId(), project1);
        projects.put(project2.getId(), project2);

        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
    }
}
