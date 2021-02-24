package com.dambue.spring_boot.service;


import com.dambue.spring_boot.model.Role;
import com.dambue.spring_boot.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {
    List<User> index();
    void save(User user);
    void delete(Long id);
    User show(Long id);
    void update(Long id, User updUser);
    UserDetails loadUserByUsername(String email);
    Role findRoleById(Long id);
}

