package ru.burmistrov.TaskManager.servlet.task;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.ITaskRepository;
import ru.burmistrov.TaskManager.entity.Task;
import ru.burmistrov.TaskManager.repository.TaskRepository;
import ru.burmistrov.TaskManager.util.DateUtil;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet("/task-create")
public class TaskCreateServlet extends HttpServlet {

    @NotNull private final ITaskRepository taskRepository = TaskRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projectId", req.getParameter("id"));
        req.getRequestDispatcher("/WEB-INF/jsp/task-create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Task task = new Task();
            task.setProjectId(req.getParameter("projectId"));
            task.setName(req.getParameter("name"));
            task.setDescription(req.getParameter("description"));
            task.setDateEnd(DateUtil.parseString(req.getParameter("dateEnd")));
            taskRepository.persist(task);
            resp.sendRedirect("/tasks?id=" + req.getParameter("projectId"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
