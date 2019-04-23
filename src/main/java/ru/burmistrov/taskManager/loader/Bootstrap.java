package ru.burmistrov.taskManager.loader;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.entity.enumerated.Role;

import javax.annotation.PostConstruct;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Bootstrap {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @NotNull
    static private final Map<String, Project> projects = new LinkedHashMap<>();

    @NotNull
    static private final Map<String, Task> tasks = new LinkedHashMap<>();

    @NotNull
    static private final Map<String, User> users = new LinkedHashMap<>();

    private Bootstrap() {
    }

    @NotNull
    public static Map<String, Project> getProjects() {
        return projects;
    }

    @NotNull
    public static Map<String, Task> getTasks() {
        return tasks;
    }

    @NotNull
    public static Map<String, User> getUsers() {
        return users;
    }

    @PostConstruct
    private void initProjectsAndTasksAndUsers() {
        User admin = new User("admin", "admin", "admin", "admin", "admin@admin");
        admin.getRoles().add(Role.ADMINISTRATOR);

        User user = new User("user", "user", "user", "user", "user@user");

        admin.setPassword(passwordEncoder.encode("admin"));
        user.setPassword(passwordEncoder.encode("user"));

        Project project1 = new Project("First Project", "First Description", new Date(), admin.getId());
        Project project2 = new Project("Second Project", "Second Description", new Date(), user.getId());

        Task task1 = new Task(project1.getId(), "First Task", "First Description", new Date(), admin.getId());
        Task task2 = new Task(project2.getId(), "Second Task", "Second Description", new Date(), user.getId());

        users.put(admin.getId(), admin);
        users.put(user.getId(), user);

        projects.put(project1.getId(), project1);
        projects.put(project2.getId(), project2);

        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
    }
}
