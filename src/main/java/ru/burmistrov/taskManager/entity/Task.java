package ru.burmistrov.taskManager.entity;

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
public final class Task {

    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String projectId;

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

    public Task(@Nullable final String projectId, @Nullable final String name, @Nullable final String description,
                @Nullable final Date dateEnd, @Nullable final String userId) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.dateEnd = dateEnd;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "; Название: " + name +
                "; Описание: " + description +
                "; ID проекта: " + projectId;
    }
}
