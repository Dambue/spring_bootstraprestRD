
package com.dambue.spring_boot.controller;


import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    private final UserDetailsService userDetailsService;

    public AdminController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping()
    public String allUsers(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userDetailsService.loadUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.index());
        return "admin";
    }

    @GetMapping("/new")
    public String newUser(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userDetailsService.loadUserByUsername(name);
        model.addAttribute("user", user);
        return "new";
    }
}

