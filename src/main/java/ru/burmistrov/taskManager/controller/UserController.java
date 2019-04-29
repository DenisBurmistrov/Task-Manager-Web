package ru.burmistrov.taskManager.controller;


import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.api.service.IUserService;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.entity.enumerated.Role;
import ru.burmistrov.taskManager.repository.IUserRepository;
import ru.burmistrov.taskManager.service.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
@URLMappings(mappings = {
        @URLMapping(id = "signUp", pattern = "/signUp", viewId = "/WEB-INF/views/signUp.xhtml"),
        @URLMapping(id = "login", pattern = "/login", viewId = "/WEB-INF/views/login.xhtml")
})
@Getter
@Setter
public class UserController {

    @ManagedProperty("#{userService}")
    private IUserService userService;

    @ManagedProperty("#{passwordEncoder}")
    private PasswordEncoder passwordEncoder;

    private String login;

    private String password;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    public String signUpPost() {
        if (userService.findOneByLogin(login) == null) {
            System.out.println(login);
            System.out.println(password);
            User user = new User();
            user.setLogin(login);
            user.setPassword(passwordEncoder.encode(password));
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMiddleName(middleName);
            user.setEmail(email);
            user.setRole(Role.COMMON_USER);
            userService.save(user);
        }
        return "login?faces-redirect=true";
    }
}

