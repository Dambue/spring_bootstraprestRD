package com.dambue.spring_boot.controller;


import com.dambue.spring_boot.model.Role;
import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model, Principal principal) {
        String name = principal.getName();
        User user = (User) userService.loadUserByUsername(name);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.index());
        return "admin";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "admin";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("/new")
    public String creat(@RequestParam("name") String name,
                        @RequestParam("last_name") String last_name,
                        @RequestParam("age") Byte age,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("roles") Long[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(userService.findRoleById(roles));
        }
        userService.save(new User(name, last_name, age, email, password, roleSet));
        return "redirect:/admin/";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "admin";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id, @RequestParam("roles") Long[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (Long roles : role) {
            roleSet.add(userService.findRoleById(roles));
        }
        user.setRoles(roleSet);
        userService.update(id, user);
        return "redirect:/admin/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/admin/";
    }
}
