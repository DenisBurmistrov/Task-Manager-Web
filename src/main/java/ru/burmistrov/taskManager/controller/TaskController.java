package ru.burmistrov.taskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.entity.CustomUser;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.repository.ITaskRepository;
import ru.burmistrov.taskManager.util.DateUtil;

import java.text.ParseException;
import java.util.Objects;

@Controller
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String createTaskGet(@RequestParam final String id, Model model) {
        model.addAttribute("id", id);
        return "task-create";
    }

    @PostMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String createTaskPost(@RequestParam final String id, @RequestParam final String name,
                                    @RequestParam final String description, @RequestParam final String dateEnd,
                                 Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        try {
            Task task = new Task();
            task.setProjectId(id);
            task.setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            task.setUserId(Objects.requireNonNull(customUser.getUser()).getId());
            taskRepository.save(task);
            model.addAttribute("id", id);
            return "redirect:tasks";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "error";
    }

    @GetMapping("/tasks")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String listTasksGet(@RequestParam final String id, Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        model.addAttribute("tasks", taskRepository.findAllByProjectId(Objects.requireNonNull(customUser.getUser()).getId(), id));
        model.addAttribute("projectId", id);
        return "task-print";
    }

    @GetMapping("/task-remove")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String removeTaskGet(@RequestParam final String id, Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Task task = taskRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
        taskRepository.delete(Objects.requireNonNull(task));
        model.addAttribute("id", Objects.requireNonNull(task).getProjectId());
        return "redirect:tasks";
    }

    @GetMapping("/task-update")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String updatetaskGet(@RequestParam final String id, Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Task task = taskRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
        model.addAttribute("task", task);
        model.addAttribute("id", id);
        return "task-update";
    }

    @PostMapping("/task-update")
    @PreAuthorize("hasAuthority('COMMON_USER')")
    public String updateProjectPost(@RequestParam final String id, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd, Model model, Authentication authentication) {
        try {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();
            Task task = taskRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
            Objects.requireNonNull(task).setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            taskRepository.save(task);
            model.addAttribute("id", task.getProjectId());
            return "redirect:tasks";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

