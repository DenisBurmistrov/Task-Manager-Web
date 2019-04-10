package ru.burmistrov.TaskManager.servlet.project;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.IProjectRepository;
import ru.burmistrov.TaskManager.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/project-remove")
public class ProjectRemoveServlet extends HttpServlet {

    @NotNull
    private final IProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        projectRepository.remove(req.getParameter("id"));
        resp.sendRedirect("/home");
    }
}
