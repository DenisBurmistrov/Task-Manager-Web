package ru.burmistrov.taskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.burmistrov.taskManager.api.repository.ITaskRepository;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Objects;

@Controller
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON')")
    public String createTaskGet(@RequestParam final String id, Model model) {
        model.addAttribute("id", id);
        return "task-create";
    }

    @PostMapping("/task-create")
    @PreAuthorize("hasAuthority('COMMON')")
    public String createTaskPost(@RequestParam final String id, @RequestParam final String name,
                                    @RequestParam final String description, @RequestParam final String dateEnd, Model model) {
        try {
            Task task = new Task();
            task.setProjectId(id);
            task.setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            task.setUserId("1");
            taskRepository.persist(task);
            model.addAttribute("id", id);
            return "redirect:tasks";
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "error";
    }

    @GetMapping("/tasks")
    @PreAuthorize("hasAuthority('COMMON')")
    public String listTasksGet(@RequestParam final String id, Model model) {
        model.addAttribute("tasks", taskRepository.findAll(id));
        model.addAttribute("projectId", id);
        return "task-print";
    }

    @GetMapping("/task-remove")
    @PreAuthorize("hasAuthority('COMMON')")
    public String removeTaskGet(@RequestParam final String id, Model model) {
        Task task = taskRepository.findOne(id);
        taskRepository.remove(id);
        model.addAttribute("id", Objects.requireNonNull(task).getProjectId());
        return "redirect:tasks";
    }

    @GetMapping("/task-update")
    @PreAuthorize("hasAuthority('COMMON')")
    public String updatetaskGet(@RequestParam final String id, Model model) {
        Task task = taskRepository.findOne(id);
        model.addAttribute("task", task);
        model.addAttribute("id", id);
        return "task-update";
    }

    @PostMapping("/task-update")
    @PreAuthorize("hasAuthority('COMMON')")
    public String updateProjectPost(@RequestParam final String id, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd, Model model) {
        try {
            Task task = taskRepository.findOne(id);
            Objects.requireNonNull(task).setName(name);
            task.setDescription(description);
            task.setDateEnd(dateUtil.parseString(dateEnd));
            taskRepository.merge(task);
            model.addAttribute("id", task.getProjectId());
            return "redirect:tasks";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

