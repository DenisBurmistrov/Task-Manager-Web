package ru.burmistrov.taskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.burmistrov.taskManager.api.repositoryInMemory.IUserRepository;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.loader.Bootstrap;

import java.util.Map;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    private Bootstrap bootstrap;

    @NotNull
    private Map<String, User> users = Bootstrap.getUsers();

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
