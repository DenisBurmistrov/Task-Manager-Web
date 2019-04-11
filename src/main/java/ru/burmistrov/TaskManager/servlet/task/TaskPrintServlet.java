package ru.burmistrov.TaskManager.servlet.task;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.ITaskRepository;
import ru.burmistrov.TaskManager.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasks")
public class TaskPrintServlet extends HttpServlet {

    @NotNull
    private final ITaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tasks", taskRepository.findAll(req.getParameter("id")));
        req.getRequestDispatcher("/WEB-INF/jsp/task-print.jsp").forward(req, resp);
    }
}
