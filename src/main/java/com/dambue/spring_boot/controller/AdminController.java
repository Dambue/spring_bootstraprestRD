
package com.dambue.spring_boot.controller;


import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userService.loadUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.index());
        return "admin";
    }

    @GetMapping("/new")
    public String newUser(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userService.loadUserByUsername(name);
        model.addAttribute("user", user);
        return "new";
    }
}

