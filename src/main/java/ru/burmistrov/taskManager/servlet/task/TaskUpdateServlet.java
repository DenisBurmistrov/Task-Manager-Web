package ru.burmistrov.taskManager.servlet.task;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.taskManager.api.repository.ITaskRepository;
import ru.burmistrov.taskManager.entity.Task;
import ru.burmistrov.taskManager.repository.TaskRepository;
import ru.burmistrov.taskManager.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Objects;

@WebServlet("/task-update")
public class TaskUpdateServlet extends HttpServlet {

    @NotNull
    private final ITaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Task task = taskRepository.findOne(id);
        req.setAttribute("task", task);
        req.setAttribute("id", id);
        req.getRequestDispatcher("/WEB-INF/jsp/task-update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Task task = taskRepository.findOne(req.getParameter("id"));
            Objects.requireNonNull(task).setName(req.getParameter("name"));
            task.setDescription(req.getParameter("description"));
            task.setDateEnd(DateUtil.parseString(req.getParameter("dateEnd")));
            taskRepository.merge(task);
            resp.sendRedirect("/tasks?id=" + task.getProjectId());
        }
        catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
