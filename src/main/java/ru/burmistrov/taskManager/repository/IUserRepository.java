package ru.burmistrov.taskManager.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.burmistrov.taskManager.entity.User;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User save(@NotNull final User user);

    void delete(@NotNull final User user);

    @Query(value = "SELECT user FROM User user WHERE user.id = :id")
    User findOne(@NotNull @Param(value = "id") final String id);

    @Query(value = "SELECT user FROM User user WHERE user.login = :login")
    User findOneByLogin(@NotNull @Param(value = "login") final String login);
}
