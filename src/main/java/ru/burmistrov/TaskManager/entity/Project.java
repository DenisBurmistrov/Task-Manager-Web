package ru.burmistrov.TaskManager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public final class Project {

    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String name;

    @Nullable
    private String description;

    @NotNull
    private Date dateBegin = new Date();

    @Nullable
    private Date dateEnd;

    @Nullable
    private String userId;

    public Project(@Nullable final String name, @Nullable final String description, @Nullable final Date dateEnd, @Nullable final String userId) {
        this.name = name;
        this.description = description;
        this.dateEnd = dateEnd;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "; Название: " + name + "; Описание: " + description + "; Дата создания: " + dateBegin;
    }
}
