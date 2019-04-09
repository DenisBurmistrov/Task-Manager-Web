package ru.burmistrov.TaskManager.servlet.project;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.loader.Bootstrap;
import ru.burmistrov.TaskManager.repository.ProjectRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class ProjectPrintServlet extends HttpServlet {

    @NotNull
    private final ProjectRepository projectRepository = ProjectRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(projectRepository.findAll());
        req.setAttribute("projects", projectRepository.findAll());
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, resp);
    }
}
