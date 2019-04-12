package ru.burmistrov.TaskManager.api.repository;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.TaskManager.entity.User;

public interface IUserRepository {

    @Nullable
    User authentication(@NotNull final String login, @NotNull final String password);

    @Nullable
    User findOne(@NotNull final String id);

    @Nullable
    User findOneByLogin(@NotNull final String login);

    @Nullable
    User persist(@NotNull final User user);
}
