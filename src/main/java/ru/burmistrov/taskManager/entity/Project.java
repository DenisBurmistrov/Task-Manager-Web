package ru.burmistrov.taskManager.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.burmistrov.taskManager.entity.enumerated.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "app_project")
@NoArgsConstructor
public final class Project {

    @NotNull
    @Id
    private String id = UUID.randomUUID().toString();

    @Nullable
    @Column(name = "name")
    private String name;

    @Nullable
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "dateBegin")
    private Date dateBegin = new Date();

    @Nullable
    @Column(name = "dateEnd")
    private Date dateEnd;

    @Nullable
    @Column(name = "user_id")
    private String userId;

    @Nullable
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Nullable
    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "projectId", orphanRemoval = true)
    private List<Task> tasks;

}
