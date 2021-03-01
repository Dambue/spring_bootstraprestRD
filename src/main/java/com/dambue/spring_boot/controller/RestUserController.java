package com.dambue.spring_boot.controller;

import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class RestUserController {

    private final UserService userService;

    public RestUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.ok().body(userService.index());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.show(id));
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
