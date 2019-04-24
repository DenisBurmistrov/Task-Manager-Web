package ru.burmistrov.taskManager.api.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.burmistrov.taskManager.entity.User;

public interface IUserService {

    User save(@NotNull final User user);

    void delete(@NotNull final User user);

    User findOne(@NotNull final String id);

    User findOneByLogin(@NotNull final String login);
}
