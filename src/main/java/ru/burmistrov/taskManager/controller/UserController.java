package ru.burmistrov.taskManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.api.repository.IUserRepository;
import ru.burmistrov.taskManager.entity.User;

import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    public String signUpGet() {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@RequestParam final String login, @RequestParam final String password, @RequestParam final String firstName,
                             @RequestParam final String lastName, @RequestParam final String middleName, @RequestParam final String email) {
            if (userRepository.findOneByLogin(login) == null) {
                User user = new User();
                user.setLogin(login);
                user.setPassword(passwordEncoder.encode(password));
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMiddleName(middleName);
                user.setEmail(email);
                userRepository.persist(user);
        }
        return "redirect:login";
    }
}

