package com.dambue.spring_boot.repository;

import com.dambue.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findByName(String name);
}
