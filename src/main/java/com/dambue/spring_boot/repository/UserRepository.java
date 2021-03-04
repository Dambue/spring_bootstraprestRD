package com.dambue.spring_boot.repository;

import com.dambue.spring_boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT b FROM User b JOIN FETCH b.roles WHERE b.email = :email")
    User findUserByEmail(String email);


}
