package ru.burmistrov.taskManager.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.entity.enumerated.Role;
import ru.burmistrov.taskManager.repository.IUserRepository;

import javax.annotation.ManagedBean;

@Component
@ManagedBean
@URLMapping(id = "signUp", pattern = "/signUp", viewId = "/WEB-INF/views/signUp.xhtml")
@Getter
@Setter
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String login;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;

    public String signUpPost() {
        if (userRepository.findOneByLogin(login) == null) {
            User user = new User();
            user.setLogin(login);
            user.setPassword(passwordEncoder.encode(password));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMiddleName(middleName);
            user.setEmail(email);
            user.setRole(Role.COMMON_USER);
            userRepository.save(user);
        }
        return "login";
    }
}

