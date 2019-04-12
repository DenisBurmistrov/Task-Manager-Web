package ru.burmistrov.TaskManager.servlet.user;

import org.jetbrains.annotations.NotNull;
import ru.burmistrov.TaskManager.api.repository.IUserRepository;
import ru.burmistrov.TaskManager.entity.User;
import ru.burmistrov.TaskManager.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/")
public class UserSignUpServlet extends HttpServlet {

    @NotNull
    private final IUserRepository userRepository = UserRepository.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (userRepository.findOneByLogin(req.getParameter("login")) == null) {
                User user = new User();
                user.setLogin(req.getParameter("login"));
                user.setHashPassword(req.getParameter("password"));
                user.setFirstName(req.getParameter("firstName"));
                user.setLastName(req.getParameter("lastName"));
                user.setMiddleName(req.getParameter("middleName"));
                user.setEmail(req.getParameter("email"));
                userRepository.persist(user);
                resp.sendRedirect("/login");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
