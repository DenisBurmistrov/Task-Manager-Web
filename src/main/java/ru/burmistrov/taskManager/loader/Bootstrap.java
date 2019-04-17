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
import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Bootstrap {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @NotNull
    static private final Map<String, User> users = new LinkedHashMap<>();

    private Bootstrap() {
    }

    @NotNull
    public static Map<String, User> getUsers() {
        return users;
    }

    @PostConstruct
    private void initProjectsAndTasksAndUsers() {
        User admin = new User("admin", "admin", "admin", "admin", "admin@admin");
        admin.getRoles().add(Role.ADMINISTRATOR);
        admin.setId("b7801a28-00ec-4b21-92f5-940c9376488a");

        User user = new User("user", "user", "user", "user", "user@user");
        user.setId("6c931f71-719c-44c7-a777-725957da3e7b");

        admin.setPassword(passwordEncoder.encode("admin"));
        user.setPassword(passwordEncoder.encode("user"));

        users.put(admin.getId(), admin);
        users.put(user.getId(), user);
    }
}
