package ru.burmistrov.TaskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.api.repository.IUserRepository;
import ru.burmistrov.TaskManager.entity.Task;
import ru.burmistrov.TaskManager.entity.User;
import ru.burmistrov.TaskManager.loader.Bootstrap;

import java.util.Map;

public class UserRepository implements IUserRepository {

    @Nullable
    private static IUserRepository instance;

    @NotNull
    private Map<String, User> users = Bootstrap.getUsers();

    @NotNull
    public static IUserRepository getInstance() {
        if(instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    @Nullable
    @Override
    public User authentication(@NotNull String login, @NotNull String password){
        for (User user : users.values()) {
            if(login.equals(user.getLogin()) && password.equals(user.getPassword()))
            return user;
        }
        return null;
    }

    @Nullable
    @Override
    public User findOne(@NotNull String id) {
        return users.get(id);
    }

    @Nullable
    @Override
    public User findOneByLogin(@NotNull String login) {
        for (User user : users.values()) {
            if(login.equals(user.getLogin()))
                return user;
        }
        return null;
    }

    @Nullable
    @Override
    public User persist(@NotNull User user) {
        users.put(user.getId(), user);
        return user;
    }
}
