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
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.api.service.IProjectService;
import ru.burmistrov.taskManager.entity.CustomUser;
import ru.burmistrov.taskManager.entity.Project;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@ManagedBean
@RequestScoped
@Getter
@Setter
@URLMappings(mappings = {
        @URLMapping(id = "projectCreate", pattern = "/project-create", viewId = "/WEB-INF/views/project-create.xhtml"),
        @URLMapping(id = "projectUpdate", pattern = "/project-update", viewId = "/WEB-INF/views/project-update.xhtml"),
        @URLMapping(id = "home", pattern = "/home", viewId = "/WEB-INF/views/home.xhtml")
})
public class ProjectController {

    @ManagedProperty("#{projectService}")
    private IProjectService projectService;

    @ManagedProperty("#{dateUtil}")
    private DateUtil dateUtil;

    @ManagedProperty("#{param.projectId}")
    private String projectId;

    @ManagedProperty("#{param.name}")
    private String name;

    @ManagedProperty("#{param.description}")
    private String description;

    @ManagedProperty("#{param.dateEnd}")
    private String dateEnd;

    private Project project;

    //@PreAuthorize("hasAuthority('COMMON_USER') or hasAuthority('ADMINISTRATOR')")
    public String createProjectPost(/*Authentication authentication*/) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUser customUser = (CustomUser) authentication.getPrincipal();
            Project project = new Project();
            project.setName(name);
            project.setDescription(description);
            System.out.println(name);
            System.out.println(dateEnd);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            project.setUserId(Objects.requireNonNull(customUser.getUser()).getId());
            projectService.save(project);
            return "home?faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public String removeProjectGet(@RequestParam final String id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        Project project = projectService.findOne(id,
                Objects.requireNonNull(customUser.getUser()).getId());
        projectService.delete(project);
        return "home?faces-redirect=true";
    }

    public String updateProjectPost() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUser customUser = (CustomUser) authentication.getPrincipal();
            project = projectService.findOne(projectId,
                    Objects.requireNonNull(customUser.getUser()).getId());
            project.setName(name);
            project.setDescription(description);
            project.setDateEnd(dateUtil.parseString(dateEnd));
            projectService.save(project);
            return "home?faces-redirect=true";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "error";
    }

    public List<Project> getProjects(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        return projectService.findAll(Objects.requireNonNull(customUser.getUser()).getId());
    }

    public void setVariables(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        project = projectService.findOne(projectId, Objects.requireNonNull(customUser.getUser()).getId());
    }
}
