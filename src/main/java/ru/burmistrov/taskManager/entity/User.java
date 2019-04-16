package ru.burmistrov.taskManager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.taskManager.entity.enumerated.Role;

import java.util.ArrayList;
import java.util.List;
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

    @NotNull
    private List<Role> roles = new ArrayList<>();

    public User(@Nullable final String firstName, @Nullable final String middleName,
                @Nullable final String lastName, @Nullable final String login,
                @Nullable final String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        roles.add(Role.COMMON);
    }

    public void setPassword(@Nullable String password) {
        this.password = password;
    }
}
