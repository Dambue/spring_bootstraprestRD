package com.dambue.spring_boot.service;

import com.dambue.spring_boot.dao.UserDAOImpl;
import com.dambue.spring_boot.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDAOImpl userRepository;

    public UserDetailsServiceImpl(UserDAOImpl userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = userRepository.getUsersWithRoles();
        for(User user: users) {
            if(user.getEmail().equals(s)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User not found");
    }
}
