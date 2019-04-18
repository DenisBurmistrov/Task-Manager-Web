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
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.repository.IProjectRepository;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Objects;

@Controller
public class ProjectController {

    @Autowired
    private IProjectRepository projectRepository;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/project-create")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
    public String createProjectGet() {
        return "project-create";
    }

    @PostMapping("/project-create")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
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
            projectRepository.save(project);
            return "redirect:home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @GetMapping("/home")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
    public String listProjectsGet(Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        model.addAttribute("projects", projectRepository.findAll(Objects.requireNonNull(customUser.getUser()).getId()));
        return "home";
    }

    @GetMapping("/project-remove")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
    public String removeProjectGet(@RequestParam final String id, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Project project = projectRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
        projectRepository.delete(project);
        return "redirect:home";
    }

    @GetMapping("/project-update")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
    public String updateProjectGet(@RequestParam final String id, Model model, Authentication authentication) {
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Project project = projectRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
        model.addAttribute("project", project);
        model.addAttribute("id", id);
        return "project-update";
    }

    @PostMapping("/project-update")
    @PreAuthorize("hasAuthority('COMMON_USER') and hasAuthority('ADMINISTRATOR')")
    public String updateProjectPost(@RequestParam final String id, @RequestParam final String name, @RequestParam final String description,
                                    @RequestParam final String dateEnd, Authentication authentication) {
        try {
            CustomUser customUser = (CustomUser) authentication.getPrincipal();
            Project project = projectRepository.findOne(id, Objects.requireNonNull(customUser.getUser()).getId());
            Objects.requireNonNull(project).setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            projectRepository.save(project);
            return "redirect:home";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }
}
