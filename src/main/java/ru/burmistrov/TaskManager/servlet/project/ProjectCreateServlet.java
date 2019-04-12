package ru.burmistrov.TaskManager.servlet.project;


import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.IProjectRepository;
import ru.burmistrov.TaskManager.entity.Project;
import ru.burmistrov.TaskManager.repository.ProjectRepository;
import ru.burmistrov.TaskManager.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/project-create")
public class ProjectCreateServlet extends HttpServlet {

    @NotNull
    private final IProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/project-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Project project = new Project();
            project.setName(req.getParameter("name"));
            project.setDescription(req.getParameter("description"));
            project.setDateEnd(DateUtil.parseString(req.getParameter("dateEnd")));
            project.setUserId((String) req.getSession().getAttribute("userId"));
            projectRepository.persist(project);
            resp.sendRedirect("/home");
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
