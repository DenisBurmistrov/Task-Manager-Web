package ru.burmistrov.taskManager.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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

    /*@GetMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")
    public String createTaskGet(@RequestParam final String id, Model model) {
        model.addAttribute("id", id);
        return "task-create";
    }*/

   /* @PostMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")*/
    public String createTaskPost(/*@RequestParam final String id, @RequestParam final String name,
                                    @RequestParam final String description, @RequestParam final String dateEnd,
                                 Model model, Authentication authentication*/) {
        //CustomUser customUser = (CustomUser) authentication.getPrincipal();
        try {
            Task task = new Task();
            task.setProjectId(projectId);
            task.setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            task.setUserId("c73a908f-41d7-407d-a7eb-4ce4e3d97be7");
            taskService.save(task);
            return "tasks?projectId=" + projectId + "&faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "error";
    }

   /* @GetMapping("/tasks")
    @PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")
    public String listTasksGet(@RequestParam final String id, Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        model.addAttribute("tasks", taskRepository.findAllByProjectId(Objects.requireNonNull(customUser.getUser()).getId(), id));
        model.addAttribute("projectId", id);
        return "task-print";
    }*/

    /*@GetMapping("/task-remove")
    @PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")*/
    public String removeTaskGet(@RequestParam final String id/*, Model model, Authentication authentication*/) {
       // CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Task task = taskService.findOne(id,"c73a908f-41d7-407d-a7eb-4ce4e3d97be7"
               /* Objects.requireNonNull(customUser.getUser()).getId()*/);
        taskService.delete(Objects.requireNonNull(task));
        //model.addAttribute("id", Objects.requireNonNull(task).getProjectId());
        return "tasks?projectId=" + projectId + "&faces-redirect=true";
    }

    /*@PostMapping("/task-update")
    @PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")*/
    public String updatTaskPost(/*@RequestParam final String taskId, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd, Model model, Authentication authentication*/) {
        try {
           // CustomUser customUser = (CustomUser) authentication.getPrincipal();
            /*Task task = taskRepository.findOne(taskId, "c73a908f-41d7-407d-a7eb-4ce4e3d97be7"
                    *//*Objects.requireNonNull(customUser.getUser()).getId()*//*);*/
            System.out.println(taskId);
            Objects.requireNonNull(task).setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            taskService.save(task);
           // model.addAttribute("id", task.getProjectId());
            return "tasks?projectId=" + projectId + "&faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public List<Task> getTasks(){
        return taskService.findAllByProjectId("c73a908f-41d7-407d-a7eb-4ce4e3d97be7", projectId);
    }

    public void setVariables(String taskId){
        task = taskService.findOne(taskId, "c73a908f-41d7-407d-a7eb-4ce4e3d97be7");
    }
}

