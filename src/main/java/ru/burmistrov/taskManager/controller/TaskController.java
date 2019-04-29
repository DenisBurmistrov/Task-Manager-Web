package ru.burmistrov.taskManager.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.api.service.ITaskService;
import ru.burmistrov.taskManager.entity.CustomUser;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.repository.ITaskRepository;
import ru.burmistrov.taskManager.service.TaskService;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@ManagedBean
@RequestScoped
@Getter
@Setter
@URLMappings(mappings = {
        @URLMapping(id = "taskCreate", pattern = "/task-create", viewId = "/WEB-INF/views/task-create.xhtml"),
        @URLMapping(id = "taskUpdate", pattern = "/task-update", viewId = "/WEB-INF/views/task-update.xhtml"),
        @URLMapping(id = "tasks", pattern = "/tasks", viewId = "/WEB-INF/views/tasks.xhtml"),
})
public class TaskController {

    @ManagedProperty("#{taskService}")
    private ITaskService taskService;

    @ManagedProperty("#{dateUtil}")
    private DateUtil dateUtil;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.description}")
    private String description;

    @ManagedProperty("#{param.dateEnd}")
    private String dateEnd;

    @ManagedProperty("#{param.projectId}")
    private String projectId;

    @ManagedProperty("#{param.taskId}")
    private String taskId;

    private Task task;

    public String createTaskPost() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        try {
            Task task = new Task();
            task.setProjectId(projectId);
            task.setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            task.setUserId(Objects.requireNonNull(customUser.getUser()).getId());
            taskService.save(task);
            return "tasks?projectId=" + projectId + "&faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "error";
    }

    public String removeTaskGet(@RequestParam final String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Task task = taskService.findOne(id,Objects.requireNonNull(customUser.getUser()).getId());
        taskService.delete(Objects.requireNonNull(task));
        return "tasks?projectId=" + projectId + "&faces-redirect=true";
    }

    public String updateTaskPost() {
        try {
            Objects.requireNonNull(task).setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            taskService.save(task);
            return "tasks?projectId=" + projectId + "&faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public List<Task> getTasks(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return taskService.findAllByProjectId(Objects.requireNonNull(customUser.getUser()).getId(), projectId);
    }

    public void setVariables(String taskId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        task = taskService.findOne(taskId, Objects.requireNonNull(customUser.getUser()).getId());
    }
}

