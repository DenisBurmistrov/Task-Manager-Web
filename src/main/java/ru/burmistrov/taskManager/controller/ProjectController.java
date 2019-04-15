package ru.burmistrov.taskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.burmistrov.taskManager.api.repository.IProjectRepository;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

@Controller
public class ProjectController {

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/project-create")
    public String createProjectGet() {
        return "project-create";
    }

    @PostMapping("/project-create")
    public String createProjectPost(@RequestParam final String name, @RequestParam final String description, @RequestParam final String dateEnd) {
        try {
            Project project = new Project();
            project.setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            projectRepository.persist(project);
            return "home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @GetMapping("/home")
    public String listProjectsGet(Model model) {
        model.addAttribute("projects", projectRepository.findAll("1"));
        return "home";
    }

    @GetMapping("/project-remove")
    public String removeProjectGet(@RequestParam final String id) {
        projectRepository.remove(id);
        return "home";
    }

    @GetMapping("/project-update")
    public String updateProjectGet(@RequestParam final String id, Model model) {
        Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        model.addAttribute("id", id);
        return "project-update";
    }

    @PostMapping("/project-update")
    public String updateProjectPost(@RequestParam final String id, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd) {
        try {
            Project project = projectRepository.findOne(id);
            Objects.requireNonNull(project).setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            projectRepository.merge(project);
            return "home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
