package ru.burmistrov.taskManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.burmistrov.taskManager.api.repository.IUserRepository;
import ru.burmistrov.taskManager.entity.User;
import ru.burmistrov.taskManager.util.PasswordUtil;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    @Autowired
    private IUserRepository userRepository;

   /* @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam final String login, @RequestParam final String password, Model model) {
        try {
            User user = userRepository.authentication(login, PasswordUtil.hashPassword(password));
            System.out.println(user);
            if(user != null) {
                model.addAttribute("userId", user.getId());
                return "redirect:home";
            }
            else {
                return "redirect:login";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "error";
    }*/

   /* @GetMapping("/logout")
    public String listTasksGet(@RequestParam final String id, Model model) {
        model.addAttribute("userId", null);
        return "login";
    }*/

    @GetMapping("/signUp")
    public String signUpGet(/*@RequestParam final String id*/) {
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@RequestParam final String login, @RequestParam final String password, @RequestParam final String firstName,
                             @RequestParam final String lastName, @RequestParam final String middleName, @RequestParam final String email) {
        try {
            if (userRepository.findOneByLogin(login) == null) {
                User user = new User();
                user.setLogin(login);
                user.setHashPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setMiddleName(middleName);
                user.setEmail(email);
                userRepository.persist(user);
                return "redirect:login";
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "error";
    }

}

