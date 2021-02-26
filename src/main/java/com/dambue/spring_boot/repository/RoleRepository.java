package com.dambue.spring_boot.repository;

import com.dambue.spring_boot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleById(Long id);
}
