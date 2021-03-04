package com.dambue.spring_boot.service;

import com.dambue.spring_boot.model.Role;
import com.dambue.spring_boot.model.User;
import com.dambue.spring_boot.repository.RoleRepository;
import com.dambue.spring_boot.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public User show(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void update(User updUser) {
        userRepository.save(updUser);
    }

    @Override
    @Transactional
    public Role findRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }
}
