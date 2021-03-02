package com.dambue.spring_boot.controller;

import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class UserController {

    private final UserService userService;

    private final UserDetailsService userDetailsService;

    public UserController(UserService userService, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping("/user")
    public String userInfo(ModelMap model, Principal principal) {
        String name = principal.getName();
        User user = (User) userDetailsService.loadUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("userNew", new User());
        model.addAttribute("users", userService.index());
        return "user";
    }
}
