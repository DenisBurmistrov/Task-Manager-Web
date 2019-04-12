package ru.burmistrov.taskManager.servlet.task;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.taskManager.api.repository.ITaskRepository;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.repository.TaskRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/task-remove")
public class TaskRemoveServlet extends HttpServlet {

    @NotNull
    private final ITaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = taskRepository.findOne(req.getParameter("id"));
        taskRepository.remove(req.getParameter("id"));
        resp.sendRedirect("/tasks?id=" + Objects.requireNonNull(task).getProjectId());
    }
}