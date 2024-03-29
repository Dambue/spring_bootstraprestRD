package com.dambue.spring_boot.service;


import com.dambue.spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void save(User user);

    void delete(Long id);

    User getUserById(Long id);

    void update(User updUser);

}

