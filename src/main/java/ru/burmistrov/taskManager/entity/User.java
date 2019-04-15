package ru.burmistrov.taskManager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import ru.burmistrov.taskManager.util.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public final class User {

    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String firstName;

    @Nullable
    private String middleName;

    @Nullable
    private String lastName;

    @Nullable
    private String login;

    @Nullable
    private String password;

    @Nullable
    private String email;

    public User(@Nullable String firstName, @Nullable String middleName, @Nullable String lastName, @Nullable String login, @Nullable String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
    }

    public void setHashPassword(@NotNull final String password) throws NoSuchAlgorithmException {
        this.password = PasswordUtil.hashPassword(password);
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }

}
