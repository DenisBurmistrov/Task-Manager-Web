package ru.burmistrov.taskManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.burmistrov.taskManager.api.repository.IProjectRepository;
import ru.burmistrov.taskManager.entity.CustomUser;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.util.Objects;

@Controller
public class ProjectController {

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/project-create")
    @PreAuthorize("hasAuthority('COMMON')")
    public String createProjectGet() {
        return "project-create";
    }

    @PostMapping("/project-create")
    @PreAuthorize("hasAuthority('COMMON')")
    public String createProjectPost
            (@RequestParam final String name, @RequestParam final String description,
             @RequestParam final String dateEnd, Authentication authentication) {
        try {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();
            Project project = new Project();
            project.setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            project.setUserId(Objects.requireNonNull(customUser.getUser()).getId());
            projectRepository.persist(project);
            return "redirect:home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('COMMON')")
    public String listProjectsGet(Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        model.addAttribute("projects", projectRepository.findAll(Objects.requireNonNull(customUser.getUser()).getId()));
        return "home";
    }

    @GetMapping("/project-remove")
    @PreAuthorize("hasAuthority('COMMON')")
    public String removeProjectGet(@RequestParam final String id) {
        projectRepository.remove(id);
        return "redirect:home";
    }

    @GetMapping("/project-update")
    @PreAuthorize("hasAuthority('COMMON')")
    public String updateProjectGet(@RequestParam final String id, Model model) {
        Project project = projectRepository.findOne(id);
        model.addAttribute("project", project);
        model.addAttribute("id", id);
        return "project-update";
    }

    @PostMapping("/project-update")
    @PreAuthorize("hasAuthority('COMMON')")
    public String updateProjectPost(@RequestParam final String id, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd) {
        try {
            Project project = projectRepository.findOne(id);
            Objects.requireNonNull(project).setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            projectRepository.merge(project);
            return "redirect:home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
