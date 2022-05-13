package com.dambue.spring_boot.controller;

import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class UserController {


    @RequestMapping("/user")
    public String userInfo(ModelMap model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "user";
    }
}
