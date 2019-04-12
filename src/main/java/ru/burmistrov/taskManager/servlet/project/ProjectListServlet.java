package ru.burmistrov.taskManager.servlet.project;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.taskManager.api.repository.IProjectRepository;
import ru.burmistrov.taskManager.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class ProjectListServlet extends HttpServlet {

    @NotNull
    private final IProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projects", projectRepository.findAll((String) req.getSession().getAttribute("userId")));
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
}
