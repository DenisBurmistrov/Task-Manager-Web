package ru.burmistrov.TaskManager.servlet.login;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.IUserRepository;
import ru.burmistrov.TaskManager.entity.User;
import ru.burmistrov.TaskManager.repository.UserRepository;
import ru.burmistrov.TaskManager.util.PasswordUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @NotNull
    private final IUserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
          User user = userRepository.authentication(req.getParameter("login"), PasswordUtil.hashPassword(req.getParameter("password")));
          if(user != null) {
              req.getSession().setAttribute("userId", user.getId());
              resp.sendRedirect("/home");
          }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
