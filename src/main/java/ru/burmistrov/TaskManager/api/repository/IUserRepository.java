package ru.burmistrov.TaskManager.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.entity.User;

public interface IUserRepository {

    @Nullable
    User authentication(String login, String password);

    @Nullable
    User findOne(@NotNull String id);
}
